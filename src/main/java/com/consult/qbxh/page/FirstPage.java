package com.consult.qbxh.page;

import com.consult.qbxh.model.CheckInfo;
import com.google.common.collect.Maps;
import com.google.inject.name.Named;
import com.google.sitebricks.At;
import com.google.sitebricks.Show;
import com.google.sitebricks.headless.Request;
import com.google.sitebricks.http.As;
import com.google.sitebricks.http.Get;
import com.google.sitebricks.http.Post;
import com.google.sitebricks.rendering.Decorated;
import com.google.sitebricks.transport.Form;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * Created by hp on 2015/6/16.
 */
@At("/register")
@Decorated
@Show("/page/FirstPage.html")
public class FirstPage extends Layout{
    private CheckInfo checkInfo;
    private Map<String,String> errorMsg;

    public FirstPage() {
        checkInfo = new CheckInfo();
        errorMsg = Maps.newHashMap();
    }

    public FirstPage(CheckInfo checkInfo, Map<String, String> errorMsg) {
        this.checkInfo = checkInfo;
        this.errorMsg = errorMsg;
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

    }

    @Post
    @As(Form.class)
    public Layout redirect(){
        System.out.println(checkInfo.getName());
        System.out.println(checkInfo.getWebsite());
        if(!StringUtils.equals(checkInfo.getName(),"上海市科学技术情报学会"))
            errorMsg.put("name","学会名称不正确");
        if(!StringUtils.startsWith(checkInfo.getWebsite(),"www.qbxh.sh.cn"))
            errorMsg.put("website","学会网址不正确");
        if(errorMsg.size()>0){
            return this;
        }else{
            return new FormPage();
        }
    }

    public String getDescription(){
        return "fasdfasd";
    }

    @Override
    public String getPageTitle() {
        return "会员注册";
    }
}
