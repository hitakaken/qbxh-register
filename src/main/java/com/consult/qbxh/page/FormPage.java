package com.consult.qbxh.page;

import com.consult.qbxh.dao.MemberDao;
import com.consult.qbxh.model.Member;
import com.google.appengine.repackaged.com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.sitebricks.At;
import com.google.sitebricks.Show;
import com.google.sitebricks.http.Post;
import com.google.sitebricks.rendering.Decorated;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;


/**
 * Created by hp on 2015/6/18.
 */
@At("/register/form")
@Decorated
@Show("/page/FormPage.html")
public class FormPage extends Layout {
    @Override
    public String getPageTitle() {
        return "上海市科学技术情报学会——信息登记";
    }

    @Inject
    private MemberDao members;

    private Member member;

    private Set<String> errors;

    public FormPage() {
        member = new Member();
        errors = Sets.newHashSet();
    }

    public FormPage(Member member) {
        this.member = member;
    }

    public String getFormSession(){
        return (String) request.getSession().getAttribute("register-session");
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Set<String> getErrors() {
        return errors;
    }

    public void setErrors(Set<String> errors) {
        this.errors = errors;
    }

    @Post
    public void post(){
        try {
            members.save(member);
        }catch (ConstraintViolationException e){
            for(ConstraintViolation constraintViolation : e.getConstraintViolations()){
                errors.add(constraintViolation.getPropertyPath().toString());
            }
        }

    }

    public boolean isMale(){
        return StringUtils.equals("男",member.getGender());
    }

    public boolean isFemale(){
        return StringUtils.equals("女",member.getGender());
    }


}
