package com.novbank.data.domain;

import java.io.Serializable;

/**
 * 实体的简单接口
 *
 * Created by CaoKe on 2015/6/21.
 */
public interface Persistable<ID extends Serializable> extends Serializable {
    /**
     * 实体的ID
     *
     * @return ID
     */
    ID getId();

    /**
     * {@code Persistable}是否为新建或已持久化
     *
     * @return 是否为新建
     */
    boolean isNew();
}
