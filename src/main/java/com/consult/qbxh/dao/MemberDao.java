package com.consult.qbxh.dao;

import com.consult.qbxh.model.Member;

import java.util.List;

/**
 * Created by hp on 2015/6/19.
 */
public interface MemberDao {
    void save(Member member);

    List<Member> findAll();

    long count();
}
