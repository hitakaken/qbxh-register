package com.consult.qbxh.page;

import com.google.inject.Inject;
import com.google.sitebricks.Show;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
}
