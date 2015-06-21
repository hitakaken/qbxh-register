package com.consult.qbxh.page;

import com.consult.qbxh.dao.MemberDao;
import com.consult.qbxh.model.Member;
import com.consult.qbxh.model.MemberFormat;
import com.google.appengine.repackaged.com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.sitebricks.At;
import com.google.sitebricks.Show;
import com.google.sitebricks.http.Get;
import com.google.sitebricks.rendering.Decorated;
import com.novbank.web.util.CsvUtils;

import java.util.List;

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

    private List<Member> items = Lists.newArrayList();

    @Get
    public void get() throws Exception {
        items = members.findAll();
        System.out.println(CsvUtils.toCSV(items,Member.class, MemberFormat.class));
    }

    public List<Member> getItems() {
        return items;
    }

    public void setItems(List<Member> items) {
        this.items = items;
    }



}
