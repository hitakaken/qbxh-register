package com.novbank.web.sitebricks;

import com.google.common.collect.Sets;
import com.google.sitebricks.SitebricksModule;

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
    }
}
