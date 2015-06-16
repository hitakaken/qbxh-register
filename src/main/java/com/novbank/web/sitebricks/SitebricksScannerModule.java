package com.novbank.web.sitebricks;

import com.google.common.collect.Sets;
import com.google.sitebricks.SitebricksModule;

import java.util.Collections;
import java.util.Set;

/**
 * Created by hp on 2015/6/16.
 */
public class SitebricksScannerModule extends SitebricksModule {
    private Set<Package> packages;

    public SitebricksScannerModule(Package... packages) {
        this.packages = Sets.newHashSet();
        Collections.addAll(this.packages,packages);
    }

    public SitebricksScannerModule addPackages(Package... packages){
        if(packages!=null){
            Collections.addAll(this.packages, packages);
        }
        return this;
    }

    @Override
    protected void configureSitebricks() {
        for(Package pkg : packages)
            scan(pkg);
    }
}
