package com.consult.qbxh.module;

import com.consult.qbxh.dao.DiskMemberDao;
import com.consult.qbxh.dao.MemberDao;
import com.consult.qbxh.model.Member;
import com.consult.qbxh.page.FirstPage;
import com.google.common.collect.Maps;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.sitebricks.persist.disk.DiskModule;
import com.novbank.web.cage.CageModule;
import com.novbank.web.sitebricks.SitebricksScannerModule;
import com.novbank.web.webjars.WebJarsModule;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import java.util.Map;

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
        Map<Class,Class> binds = Maps.newHashMap();
        binds.put(MemberDao.class, DiskMemberDao.class);
        return Guice.createInjector(
                new WebJarsModule("assets"),
                new CageModule(),
                new SitebricksScannerModule(binds,FirstPage.class.getPackage()),
                new DiskModule("data\\qbxh\\index"){
                    @Override
                    protected void configurePersistence() {
                        scan(Member.class.getPackage());
                    }
                },
                new QbxhShiroWebModule(this.servletContext));
    }
}

