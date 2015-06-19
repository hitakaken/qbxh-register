package com.consult.qbxh.page;

import com.consult.qbxh.model.CheckInfo;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.google.sitebricks.At;
import com.google.sitebricks.Show;
import com.google.sitebricks.headless.Reply;
import com.google.sitebricks.headless.Request;
import com.google.sitebricks.headless.Service;
import com.google.sitebricks.http.As;
import com.google.sitebricks.http.Get;
import com.google.sitebricks.http.Post;
import com.google.sitebricks.rendering.Decorated;
import com.google.sitebricks.transport.Form;
import com.novbank.web.cage.CageService;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * Created by hp on 2015/6/16.
 */
@At("/register")
@Decorated
@Show("/page/FirstPage.html")
public class FirstPage extends Layout{
    @Override
    public String getPageTitle() {
        return "上海市科学技术情报学会——会员注册";
    }

    @Inject
    private CageService service;

    private CheckInfo checkInfo;

    public FirstPage() {
        checkInfo = new CheckInfo();
    }


    public CheckInfo getCheckInfo() {
        return checkInfo;
    }

    public void setCheckInfo(CheckInfo checkInfo) {
        this.checkInfo = checkInfo;
    }

    private boolean newly = true;


    public boolean isErrorName(){
        return !newly && !StringUtils.equals(checkInfo.getName(), ("上海市科学技术情报学会"));
    }

    public boolean isErrorWebsite(){
        return !newly && !StringUtils.startsWith(checkInfo.getWebsite(), "www.qbxh.sh.cn");
    }

    public boolean isErrorCage(){
        return !newly && !service.match(request.getSession(),checkInfo.getChecksum());
    }

    @Post
    public void post() throws IOException {
        HttpSession session = request.getSession();
        newly = false;
        if(!isErrorName() && !isErrorWebsite() && !isErrorCage()){
            String uuid = UUID.randomUUID().toString();
            session.setAttribute("register-session", uuid);
            service.clear(session);
            response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            response.sendRedirect(request.getContextPath() + "/register/form");
        }
    }
}
