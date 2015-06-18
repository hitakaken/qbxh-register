package com.consult.qbxh.module;

import com.consult.qbxh.page.FirstPage;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.novbank.web.sitebricks.SitebricksScannerModule;
import com.novbank.web.webjars.WebJarsModule;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

/**
 * Created by hp on 2015/6/15.
 */
public class WebAppListener extends GuiceServletContextListener {
    private ServletContext servletContext;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        this.servletContext = servletContextEvent.getServletContext();
        super.contextInitialized(servletContextEvent);
    }

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(
                new WebJarsModule("assets"),
                new SitebricksScannerModule(FirstPage.class.getPackage()),
                new QbxhShiroWebModule(this.servletContext));
    }
}

