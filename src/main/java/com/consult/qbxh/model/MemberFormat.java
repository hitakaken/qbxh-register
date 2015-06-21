package com.consult.qbxh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by hp on 2015/6/21.
 */
@JsonPropertyOrder(value={"fullname","gender","birthday","email","mobile","id","qq","weixin",
        "country","nationality","hometown","political","education","degree",
        "background","engage","jobTitle","company","department","position","workPhone","workAddress","workZipCode",
        "socialWork","socialHonor","academicNational","academicInternational" })
public abstract class MemberFormat {
    //@JsonProperty("姓名")
    public abstract String getName();

    //@JsonProperty("性别")
    public abstract String getGender();

    public abstract String getBirthday();

    public abstract String getEmail();

    public abstract String getMobile();

    public abstract String getJobTitle();

    public abstract String getEducation();

    public abstract String getDegree();

    public abstract String getBackground();

    public abstract String getEngage();

    public abstract String getCompany();

    public abstract String getDepartment();

    public abstract String getPosition();

    public abstract String getWorkPhone();

    public abstract String getWorkAddress();

    public abstract String getWorkZipCode();

    public abstract String getCountry();

    public abstract String getNationality();

    public abstract String getHometown();

    public abstract String getPolitical();

    public abstract String getQq();

    public abstract String getWeixin();

    public abstract String getSocialWork();

    public abstract String getSocialHonor();

    public abstract String getAcademicNational();

    public abstract String getAcademicInternational();

    public abstract String getId();
}
