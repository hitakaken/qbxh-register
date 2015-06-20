package com.novbank.web.webjars;


import com.google.inject.Singleton;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webjars.WebJarAssetLocator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by hp on 2015/6/16.
 */
@Singleton
public class WebJarsServlet extends HttpServlet{
    private static final Logger LOG = LoggerFactory.getLogger(WebJarsServlet.class);
    private static final long DEFAULT_EXPIRE_TIME_MS = 86400000L; // 1 day
    private static final long DEFAULT_EXPIRE_TIME_S = 86400L; // 1 day

    private boolean disableCache = false;
    private WebJarAssetLocator locator;
    private String basePath;

    @Override
    public void init(ServletConfig config) throws ServletException {
        locator = new WebJarAssetLocator();
        try {
            String disableCache = config.getInitParameter("disableCache");
            if (disableCache != null) {
                this.disableCache = Boolean.parseBoolean(disableCache);
                LOG.info("WebjarsServlet cache enabled: " + !this.disableCache);
            }
            basePath = config.getInitParameter(WebJarsModule.WEBJARS_URL);
            if(basePath == null) basePath = WebJarsModule.DEFAULT_WEBJARS_URL;
        } catch (Exception e) {
            LOG.warn("The WebjarsServlet configuration parameter \"disableCache\" is invalid");
        }
        LOG.info("WebjarsServlet initialization completed");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestPath = StringUtils.substring(request.getRequestURI(),request.getContextPath().length() + basePath.length()+2);
        String webjar  = StringUtils.substringBefore(requestPath,"/");
        String partialPath  = StringUtils.substringAfter(requestPath, "/");
        String version = locator.getWebJars().get(webjar);
        String webjarsResourceURI = locator.getFullPath(webjar,StringUtils.isNotBlank(version)? version + "/" +partialPath:partialPath);
        //String webjarsResourceURI = "/META-INF/resources" + request.getRequestURI().replaceFirst(request.getContextPath(), "");
        LOG.info("Webjars resource requested: " + webjarsResourceURI);
        InputStream inputStream = this.getClass().getResourceAsStream("/"+webjarsResourceURI);
        if (inputStream != null) {
            if (!disableCache) {
                prepareCacheHeaders(response, webjarsResourceURI);
            }
            String filename = getFileName(webjarsResourceURI);
            String mimeType = request.getSession().getServletContext().getMimeType(filename);
            response.setContentType(mimeType != null? mimeType:"application/octet-stream");
            IOUtils.copy(inputStream,response.getOutputStream());
        } else {
            // return HTTP error
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        //IOUtils.closeQuietly(inputStream);
    }

    /**
     *
     * @param webjarsResourceURI
     * @return
     */
    private String getFileName(String webjarsResourceURI) {
        String[] tokens = webjarsResourceURI.split("/");
        return tokens[tokens.length - 1];
    }
    /**
     *
     * @param response
     * @param webjarsResourceURI
     */
    private void prepareCacheHeaders(HttpServletResponse response, String webjarsResourceURI) {
        String[] tokens = webjarsResourceURI.split("/");
        String version = tokens[5];
        String fileName = tokens[tokens.length - 1];

        String eTag = fileName + "_" + version;
        response.setHeader("ETag", eTag);
        response.setDateHeader("Expires", System.currentTimeMillis() + DEFAULT_EXPIRE_TIME_MS);
        response.addHeader("Cache-Control", "private, max-age=" + DEFAULT_EXPIRE_TIME_S);
    }

}
