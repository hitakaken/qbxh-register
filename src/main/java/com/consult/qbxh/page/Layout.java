package com.consult.qbxh.page;

import com.google.inject.Inject;
import com.google.sitebricks.Show;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hp on 2015/6/18.
 */
@Show("/page/Layout.html")
public abstract class Layout {
    @Inject
    protected HttpServletRequest request;

    @Inject
    protected HttpServletResponse response;

    public abstract String getPageTitle();

    public String getIe8_support(){
        return "<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\n" +
                "    <!--[if lt IE 9]>\n" +
                "    <script src=\"/qbxh/assets/bootswatch/bower_components/html5shiv/dist/html5shiv.js\"></script>\n" +
                "    <script src=\"/qbxh/assets/bootswatch/bower_components/respond/dest/respond.min.js\"></script>\n" +
                "    <![endif]-->";
    }

    protected void redirect(String url) throws IOException {
        response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        response.sendRedirect(request.getContextPath() + url);
    }
}
