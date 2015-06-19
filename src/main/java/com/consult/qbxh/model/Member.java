package com.consult.qbxh.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by hp on 2015/6/19.
 */
public class Member implements Serializable {
    @NotNull
    @Size(min = 2, max = 20)
    private String name;

    @NotNull
    @Pattern(regexp = "男|女")
    private String gender;

    @NotNull
    @Pattern(regexp = "\\d{6}")
    private String birthday;

    @NotNull
    @Pattern(regexp = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?")
    private String email;

    @NotNull
    private String mobile;

    @NotNull
    private String jobTitle;

    @NotNull
    private String education;

    @NotNull
    private String degree;

    @NotNull
    private String background;

    @NotNull
    private String engage;

    @NotNull
    private String company;

    @NotNull
    private String department;

    @NotNull
    private String position;

    @NotNull
    private String workPhone;

    @NotNull
    private String workAddress;

    @NotNull
    @Pattern(regexp = "[1-9]\\d{5}(?!\\d)")
    private String workZipCode;

    @NotNull
    private String country;

    @NotNull
    private String nationality;

    @NotNull
    private String hometown;

    @Pattern(regexp = "[1-9][0-9]{4,}")
    private String qq;

    private String weixin;

    @NotNull
    private String socialWork;

    @NotNull
    private String socialHonor;

    private String academicNational;

    private String academicInternational;

    @Pattern(regexp = "(^(\\d{6})(\\d{4})(\\d{2})(\\d{2})(\\d{3})([0-9]|X)$)|(^(\\d{6})(\\d{2})(\\d{2})(\\d{2})(\\d{3})$)|\\s+")
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getEngage() {
        return engage;
    }

    public void setEngage(String engage) {
        this.engage = engage;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public String getWorkZipCode() {
        return workZipCode;
    }

    public void setWorkZipCode(String workZipCode) {
        this.workZipCode = workZipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getSocialWork() {
        return socialWork;
    }

    public void setSocialWork(String socialWork) {
        this.socialWork = socialWork;
    }

    public String getSocialHonor() {
        return socialHonor;
    }

    public void setSocialHonor(String socialHonor) {
        this.socialHonor = socialHonor;
    }

    public String getAcademicNational() {
        return academicNational;
    }

    public void setAcademicNational(String academicNational) {
        this.academicNational = academicNational;
    }

    public String getAcademicInternational() {
        return academicInternational;
    }

    public void setAcademicInternational(String academicInternational) {
        this.academicInternational = academicInternational;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
