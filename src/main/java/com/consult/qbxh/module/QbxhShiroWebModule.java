package com.consult.qbxh.module;

import com.consult.qbxh.realm.QbxhAuthorizingRealm;
import com.google.inject.name.Names;
import org.apache.shiro.guice.web.ShiroWebModule;

import javax.servlet.ServletContext;

/**
 * Created by hp on 2015/6/15.
 */
public class QbxhShiroWebModule extends ShiroWebModule {
    public QbxhShiroWebModule(ServletContext servletContext) {
        super(servletContext);
    }

    @Override
    protected void configureShiroWeb() {
        bindConstant().annotatedWith(Names.named("shiro.globalSessionTimeout")).to(30000L);

        bindRealm().to(QbxhAuthorizingRealm.class).asEagerSingleton();

        addFilterChain("/login.jsp", AUTHC);
        addFilterChain("/api/*", AUTHC);
    }

}
