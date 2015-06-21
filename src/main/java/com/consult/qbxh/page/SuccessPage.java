package com.consult.qbxh.page;

import com.google.sitebricks.At;
import com.google.sitebricks.Show;
import com.google.sitebricks.rendering.Decorated;

/**
 * Created by hp on 2015/6/19.
 */
@At("/register/success")
@Decorated
@Show("/page/SuccessPage.html")
public class SuccessPage  extends Layout  {
    @Override
    public String getPageTitle() {
        return "上海市科学技术情报学会——注册成功";
    }
}
