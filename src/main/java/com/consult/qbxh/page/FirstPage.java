package com.consult.qbxh.page;

import com.consult.qbxh.model.CheckInfo;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.google.sitebricks.At;
import com.google.sitebricks.Show;
import com.google.sitebricks.headless.Request;
import com.google.sitebricks.headless.Service;
import com.google.sitebricks.http.As;
import com.google.sitebricks.http.Get;
import com.google.sitebricks.http.Post;
import com.google.sitebricks.rendering.Decorated;
import com.google.sitebricks.transport.Form;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by hp on 2015/6/16.
 */
@At("/register")
@Decorated
@Show("/page/FirstPage.html")
@Service
public class FirstPage extends Layout{
    @Inject
    private HttpServletRequest request;

    @Override
    public String getPageTitle() {
        return "会员注册";
    }

    private CheckInfo checkInfo;
    private Map<String,String> errorMsg;

    public FirstPage() {
        checkInfo = new CheckInfo();
        errorMsg = Maps.newHashMap();
    }

    public FirstPage(CheckInfo checkInfo, Map<String, String> errorMsg) {
        this.checkInfo = checkInfo;
        System.out.println(this.checkInfo);
        this.errorMsg = Maps.newHashMap(errorMsg);
    }

    public CheckInfo getCheckInfo() {
        return checkInfo;
    }

    public void setCheckInfo(CheckInfo checkInfo) {
        this.checkInfo = checkInfo;
    }

    public Map<String, String> getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(Map<String, String> errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Get
    public void get(){
        System.out.println("get");
        System.out.println(checkInfo);
    }

    public boolean isError(){
        return errorMsg.size()>0;
    }

    @Post
    Layout redirect(){
        HttpSession session = request.getSession();
        System.out.println(checkInfo.getName());
        System.out.println(checkInfo.getWebsite());
        if(!StringUtils.equals(checkInfo.getName(), "上海市科学技术情报学会"))
            errorMsg.put("name","学会名称不正确");
        if(!StringUtils.startsWith(checkInfo.getWebsite(),"www.qbxh.sh.cn"))
            errorMsg.put("website","学会网址不正确");
        if(errorMsg.size()>0){
            return new FirstPage(checkInfo,errorMsg);
        }else{
            return new FormPage("4321432143214fasdfasdf");
        }
    }
}
