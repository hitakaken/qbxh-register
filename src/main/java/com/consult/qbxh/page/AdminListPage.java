package com.consult.qbxh.page;

import com.consult.qbxh.dao.MemberDao;
import com.consult.qbxh.model.Member;
import com.google.inject.Inject;
import com.google.sitebricks.At;
import com.google.sitebricks.Show;
import com.google.sitebricks.http.Get;
import com.google.sitebricks.rendering.Decorated;

/**
 * Created by CaoKe on 2015/6/20.
 */
@At("/admin/list")
@Decorated
@Show("/page/AdminListPage.html")
public class AdminListPage extends Layout{
    @Inject
    private MemberDao members;

    @Override
    public String getPageTitle() {
        return "会员列表";
    }

    @Get
    public void get(){
        for(Member member:members.findAll()){
            System.out.println(member.getName());
        }
    }
}
