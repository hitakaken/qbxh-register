package com.consult.qbxh.dao;

import com.consult.qbxh.model.Member;
import org.apache.bval.guice.Validate;

import javax.validation.Valid;
import javax.validation.ValidationException;

/**
 * Created by hp on 2015/6/19.
 */
public class DiskMemberDao implements MemberDao {

    @Validate
    @Override
    public void save(@Valid Member member) {

    }
}
