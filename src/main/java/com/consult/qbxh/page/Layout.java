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

    protected void redirect(String url) throws IOException {
        response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        response.sendRedirect(request.getContextPath() + url);
    }
}
