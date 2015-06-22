package com.consult.qbxh;

import com.consult.qbxh.module.WebAppListener;
import com.google.inject.servlet.GuiceFilter;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Created by hp on 2015/6/12.
 */
public class Bootstrap {
    public static void main(String[] args) throws Exception{
        Server server = new Server(8080);

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/qbxh/");
        webAppContext.setResourceBase("src/main/webapp/");
        webAppContext.setParentLoaderPriority(true);
        webAppContext.addEventListener(new WebAppListener());
        webAppContext.addFilter(GuiceFilter.class, "/*", null);
        server.setHandler(webAppContext);

        server.start();
        server.join();
    }

}
