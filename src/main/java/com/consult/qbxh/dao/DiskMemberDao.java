package com.consult.qbxh.dao;

import com.consult.qbxh.model.Member;
import com.google.sitebricks.persist.EntityStore;
import com.google.sitebricks.persist.Persister;
import org.apache.bval.guice.Validate;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by hp on 2015/6/19.
 */
public class DiskMemberDao implements MemberDao {
    @Inject
    private Persister persister;

    @Validate
    @Override
    public void save(final @Valid Member member) {
        persister.call(new Persister.InWork() {
            @Override
            public Object perform(EntityStore es) throws Throwable {
                es.save(member);
                return null;
            }
        });
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Member> findAll() {
        return (List<Member>) persister.call(new Persister.InWork() {
            @Override
            public Object perform(EntityStore es) throws Throwable {
                return es.all(Member.class);
            }
        });
    }
}
