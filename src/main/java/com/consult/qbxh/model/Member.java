package com.consult.qbxh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.google.sitebricks.persist.Indexed;
import com.novbank.web.Regexp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by hp on 2015/6/19.
 */
@Entity
public class Member implements Serializable {
    @Id
    @NotNull
    @JsonPropertyDescription()
    private String sessionId;

    @Indexed
    @NotNull
    @Size(min = 2, max = 200)
    private String name;

    @NotNull
    @Pattern(regexp = "男|女")
    private String gender;

    @NotNull
    @Pattern(regexp = "\\d{6}")
    private String birthday;

    @Indexed
    @NotNull
    @Pattern(regexp = Regexp.EMAIL)
    private String email;

    @Indexed
    @NotNull
    @Pattern(regexp = Regexp.MOBILE)
    private String mobile;

    @Indexed
    @NotNull
    @Size(max = 200)
    private String jobTitle;

    @Indexed
    @NotNull
    @Size(max = 200)
    private String education;

    @Indexed
    @NotNull
    @Size(max = 200)
    private String degree;

    @Indexed
    @NotNull
    @Size(max = 200)
    private String background;

    @Indexed
    @NotNull
    @Size(max = 200)
    private String engage;

    @Indexed
    @NotNull
    @Size(max = 200)
    private String company;

    @Indexed
    @NotNull
    @Size(max = 200)
    private String department;

    @Indexed
    @NotNull
    @Size(max = 200)
    private String position;

    @NotNull
    @Pattern(regexp = "[-0-9]{7,}")
    private String workPhone;

    @Indexed
    @NotNull
    @Size(max = 1000)
    private String workAddress;

    @Indexed
    @NotNull
    @Pattern(regexp = Regexp.ZIP_CODE)
    private String workZipCode;

    @Indexed
    @NotNull
    @Size(max = 200)
    private String country;

    @Indexed
    @NotNull
    @Size(max = 200)
    private String nationality;

    @NotNull
    @Size(max = 200)
    private String hometown;

    @NotNull
    @Size(max = 200)
    private String political;

    @Pattern(regexp = Regexp.QQ)
    private String qq;

    @Size(max = 200)
    private String weixin;

    @Size(max = 2000)
    private String socialWork;

    @Size(max = 2000)
    private String socialHonor;

    @Size(max = 2000)
    private String academicNational;

    @Size(max = 2000)
    private String academicInternational;

    @Pattern(regexp = Regexp.ID)
    private String id;

    public Member() {
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

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

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
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
