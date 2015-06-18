package com.novbank.web.sitebricks;

import com.google.common.collect.Sets;
import com.google.inject.matcher.Matchers;
import com.google.sitebricks.SitebricksModule;
import com.google.sitebricks.rendering.Decorated;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Set;

/**
 * Created by hp on 2015/6/16.
 */
public class SitebricksScannerModule extends SitebricksModule {
    private Set<Package> packages;

    public SitebricksScannerModule(Package... packages) {
        this.packages = Sets.newHashSet();
        if(packages!=null){
            for(Package pkg : packages){
                if(pkg!=null) this.packages.add(pkg);
            }

        }
    }

    public SitebricksScannerModule addPackages(Package... packages){
        if(packages!=null){
            for(Package pkg : packages)
                if(pkg!=null) this.packages.add(pkg);
        }
        return this;
    }

    @Override
    protected void configureSitebricks() {
        for(Package pkg : packages)
            scan(pkg);

        // Bind a dummy interceptor to specifically test AOP interaction with decorated pages.
        bindInterceptor(Matchers.annotatedWith(Decorated.class), Matchers.any(), new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation methodInvocation) throws Throwable {
                return methodInvocation.proceed();
            }
        });
    }
}
