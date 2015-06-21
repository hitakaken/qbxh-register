package com.consult.qbxh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by hp on 2015/6/21.
 */
@JsonPropertyOrder(value={"工作单位","所属部门","姓名","电子邮件","手机","识别码","性别","出生年月","身份证","QQ","微信",
        "国籍","民族","籍贯","政治面貌","学历","学位",
        "专业背景","现从事专业","职称","现任职务","固定电话","单位地址","单位邮编",
        "主要社会职务","主要社会荣誉","参加全国性学术社团及任职情况","参加国际性学术社团及任职情况"})
public abstract class MemberFormat {
    @JsonProperty("识别码")
    public abstract String getSessionId();

    @JsonProperty("姓名")
    public abstract String getName();

    @JsonProperty("性别")
    public abstract String getGender();

    @JsonProperty("出生年月")
    public abstract String getBirthday();

    @JsonProperty("电子邮件")
    public abstract String getEmail();

    @JsonProperty("手机")
    public abstract String getMobile();

    @JsonProperty("职称")
    public abstract String getJobTitle();

    @JsonProperty("学历")
    public abstract String getEducation();

    @JsonProperty("学位")
    public abstract String getDegree();

    @JsonProperty("专业背景")
    public abstract String getBackground();

    @JsonProperty("现从事专业")
    public abstract String getEngage();

    @JsonProperty("工作单位")
    public abstract String getCompany();

    @JsonProperty("所属部门")
    public abstract String getDepartment();

    @JsonProperty("现任职务")
    public abstract String getPosition();

    @JsonProperty("固定电话")
    public abstract String getWorkPhone();

    @JsonProperty("单位地址")
    public abstract String getWorkAddress();

    @JsonProperty("单位邮编")
    public abstract String getWorkZipCode();

    @JsonProperty("国籍")
    public abstract String getCountry();

    @JsonProperty("民族")
    public abstract String getNationality();

    @JsonProperty("籍贯")
    public abstract String getHometown();

    @JsonProperty("政治面貌")
    public abstract String getPolitical();

    @JsonProperty("QQ")
    public abstract String getQq();

    @JsonProperty("微信")
    public abstract String getWeixin();

    @JsonProperty("主要社会职务")
    public abstract String getSocialWork();

    @JsonProperty("主要社会荣誉")
    public abstract String getSocialHonor();

    @JsonProperty("参加全国性学术社团及任职情况")
    public abstract String getAcademicNational();

    @JsonProperty("参加国际性学术社团及任职情况")
    public abstract String getAcademicInternational();

    @JsonProperty("身份证")
    public abstract String getId();
}

