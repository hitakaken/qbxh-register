package com.consult.qbxh.module;

import com.consult.qbxh.servlet.WebJarsServlet;
import com.google.inject.servlet.ServletModule;

/**
 * Created by hp on 2015/6/15.
 */
public class QbxhAppServletModule extends ServletModule {
    @Override
    protected void configureServlets() {

        serve("/webjars/*").with(WebJarsServlet.class);
    }
}
