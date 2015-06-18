package com.consult.qbxh.page;

import com.google.sitebricks.At;
import com.google.sitebricks.Show;

/**
 * Created by hp on 2015/6/18.
 */
@At("/register/form")
@Show("/page/FormPage.html")
public class FormPage extends Layout {
    @Override
    public String getPageTitle() {
        return "会员信息";
    }

}
