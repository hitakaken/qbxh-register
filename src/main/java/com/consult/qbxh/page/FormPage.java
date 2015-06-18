package com.consult.qbxh.page;

import com.google.sitebricks.At;
import com.google.sitebricks.Show;
import com.google.sitebricks.rendering.Decorated;

/**
 * Created by hp on 2015/6/18.
 */
@At("/register/form")
@Decorated
@Show("/page/FormPage.html")
public class FormPage extends Layout {
    @Override
    public String getPageTitle() {
        return "会员信息";
    }

    private String sessionId;

    public FormPage(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }
}
