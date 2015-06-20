package com.consult.qbxh.page;

import com.consult.qbxh.dao.MemberDao;
import com.consult.qbxh.model.Member;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.sitebricks.At;
import com.google.sitebricks.Show;
import com.google.sitebricks.http.Get;
import com.google.sitebricks.http.Post;
import com.google.sitebricks.rendering.Decorated;
import com.novbank.web.util.FormUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;


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

    @Get
    public void get() throws IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("register-session")==null){
            member.setSessionId(UUID.randomUUID().toString());
            /*response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            response.sendRedirect(request.getContextPath() + "/register");*/
        }else{
            member.setSessionId((String) session.getAttribute("register-session"));
        }
    }

    @Post
    public void post(){
        //1.检查 sessionId

        //2.校验并保存
        try {
            FormUtils.trimToNull(member);
            members.save(member);
        }catch (ConstraintViolationException e){
            for(ConstraintViolation constraintViolation : e.getConstraintViolations()){
                errors.add(constraintViolation.getPropertyPath().toString());
            }
        }
        System.out.println(errors);
        if(errors.size()==0){
            System.out.println("persist");
        }
    }

    public boolean isMale(){
        return StringUtils.equals("男",member.getGender());
    }

    public boolean isFemale(){
        return StringUtils.equals("女",member.getGender());
    }

    public List<String> getParties(){
        return parties;
    }

    public List<String> getEducations() {
        return educations;
    }

    public List<String> getDegrees() {
        return degrees;
    }

    public static final List<String> parties = Arrays.asList("中共党员","中共预备党员","共青团员",
            "民革党员", "民盟盟员","民建会员","民进会员", "农工党党员",
            "致公党党员","九三学社社员","台盟盟员","无党派人士","普通居民");

    public static final List<String> educations = Arrays.asList("大专","本科","硕士研究生","博士研究生","其他");

    public static final List<String> degrees = Arrays.asList("学士","硕士","博士","其他");
}
