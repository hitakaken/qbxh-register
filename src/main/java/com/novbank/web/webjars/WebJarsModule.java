package com.novbank.web.webjars;

import com.google.common.collect.ImmutableMap;
import com.google.inject.servlet.ServletModule;

/**
 * Created by hp on 2015/6/16.
 */
public class WebJarsModule extends ServletModule {
    static final String WEBJARS_URL = "webjars_url";
    static final String DEFAULT_WEBJARS_URL = "webjars";
    private String basePath;

    public WebJarsModule() {
        this(DEFAULT_WEBJARS_URL);
    }

    public WebJarsModule(String basePath) {
        this.basePath = basePath;
    }

    @Override
    protected void configureServlets() {
        serve("/"+basePath+"/*").with(WebJarsServlet.class, ImmutableMap.of(WEBJARS_URL, basePath));
    }
}
