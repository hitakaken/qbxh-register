package com.novbank.data.domain;

/**
 * Created by CaoKe on 2015/6/21.
 */
public interface Pageable {
    int getPageNumber();

    int getPageSize();

    int getOffset();

    Sort getSort();

    Pageable next();

    Pageable previousOrFirst();

    Pageable first();

    boolean hasPrevious();
}
