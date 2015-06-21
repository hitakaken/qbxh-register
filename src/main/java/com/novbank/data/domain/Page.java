package com.novbank.data.domain;

import com.google.common.base.Converter;

/**
 * Created by CaoKe on 2015/6/21.
 */
public interface Page<T> extends Slice<T> {
    int getTotalPages();

    long getTotalElements();

    <S> Page<S> map(Converter<? super T, ? extends S> converter);
}
