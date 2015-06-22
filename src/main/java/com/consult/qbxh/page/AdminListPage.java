package com.consult.qbxh.page;

import com.consult.qbxh.dao.MemberDao;
import com.consult.qbxh.model.Member;
import com.consult.qbxh.model.MemberFormat;
import com.google.appengine.repackaged.com.google.common.collect.ImmutableMap;
import com.google.appengine.repackaged.com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.sitebricks.At;
import com.google.sitebricks.Show;
import com.google.sitebricks.client.transport.Raw;
import com.google.sitebricks.headless.Reply;
import com.google.sitebricks.http.Get;
import com.google.sitebricks.rendering.Decorated;
import com.novbank.web.util.CsvUtils;
import com.novbank.web.util.RequestUtils;
import org.apache.commons.lang3.StringUtils;

import java.net.URLEncoder;
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
        if(!isAdmin()) redirect("/register");
        items = members.findAll();
    }

    @At("/csv")
    @Get
    public Reply<?> getCsv() throws Exception{
        if(!isAdmin()) redirect("/register");
        items = members.findAll();
        System.out.println("CSV Request");
        String text = CsvUtils.toCSV(items, Member.class, MemberFormat.class);
        return Reply.with(text.getBytes("GBK")).headers(
                ImmutableMap.of(
                        "Content-type", "text/csv;charset=GBK",
                        "Content-disposition", "attachment; filename=" + URLEncoder.encode("情报学会会员列表", "utf-8") + ".csv"
                )).as(Raw.class);
    }

    public List<Member> getItems() {
        return items;
    }

    public void setItems(List<Member> items) {
        this.items = items;
    }

    public boolean isAdmin(){
        String ip = RequestUtils.getClientIpAddress(request);
        return StringUtils.equals(ip,"127.0.0.1") || StringUtils.startsWith(ip,"10.1.80.");
    }
}
