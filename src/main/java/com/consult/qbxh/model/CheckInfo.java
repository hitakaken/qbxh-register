package com.consult.qbxh.model;

/**
 * Created by hp on 2015/6/18.
 */
public class CheckInfo {
    private String name;
    private String website;
    private String checksum;

    public CheckInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    @Override
    public String toString() {
        return "CheckInfo{" +
                "name='" + name + '\'' +
                ", website='" + website + '\'' +
                ", checksum='" + checksum + '\'' +
                '}';
    }
}
