package com.novbank.web.cage;

import com.google.common.collect.ImmutableMap;
import com.google.inject.servlet.ServletModule;

import java.util.concurrent.TimeUnit;

/**
 * Created by hp on 2015/6/19.
 */
public class CageModule extends ServletModule {
    static final String DEFAULT_CAGE_URL = "/cage.jpg";
    static final long DEFAULT_CACHE_TIME = 3;
    static final TimeUnit DEFAULT_CACHE_TIME_UNIT = TimeUnit.MINUTES;

    private String cageUrl;
    private long cacheTime;
    private TimeUnit cacheTimeUnit;

    public CageModule() {
        this(DEFAULT_CAGE_URL);
    }

    public CageModule(String cageUrl) {
        this(cageUrl,DEFAULT_CACHE_TIME);
    }

    public CageModule(String cageUrl,long cacheTime) {
        this(cageUrl,cacheTime,DEFAULT_CACHE_TIME_UNIT);
    }

    public CageModule(String cageUrl, long cacheTime, TimeUnit cacheTimeUnit) {
        this.cageUrl = cageUrl;
        this.cacheTime = cacheTime;
        this.cacheTimeUnit = cacheTimeUnit;
    }

    @Override
    protected void configureServlets() {
        bind(CageService.class).toInstance(new CageService(cacheTime,cacheTimeUnit));
        serve(cageUrl).with(CageServlet.class);
    }
}
