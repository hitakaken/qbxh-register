package com.novbank.web.sitebricks;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.matcher.Matchers;
import com.google.sitebricks.SitebricksModule;
import com.google.sitebricks.conversion.DateConverters;
import com.google.sitebricks.ext.SitebricksValidationExtModule;
import com.google.sitebricks.rendering.Decorated;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.bval.guice.ValidationModule;

import java.util.Map;
import java.util.Set;

/**
 * Created by hp on 2015/6/16.
 */
public class SitebricksScannerModule extends SitebricksModule {
    private Set<Package> packages;
    private Map<Class,Class> binds;

    public SitebricksScannerModule(Package... packages) {
        this(Maps.<Class, Class>newHashMap(),packages);
    }

    public SitebricksScannerModule(Map<Class,Class> binds, Package... packages) {
        this.binds = binds;
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
        // Validation
        install(new SitebricksValidationExtModule());
        install(new ValidationModule());

        for(Class key : binds.keySet())
            bind(key).to(binds.get(key));

        for(Package pkg : packages) scan(pkg);

        // Bind a dummy interceptor to specifically test AOP interaction with decorated pages.
        bindInterceptor(Matchers.annotatedWith(Decorated.class), Matchers.any(), new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation methodInvocation) throws Throwable {
                return methodInvocation.proceed();
            }
        });
        converter(new DateConverters.DateStringConverter(DEFAULT_DATE_TIME_FORMAT));
    }

    // a weird format
    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd";
}
