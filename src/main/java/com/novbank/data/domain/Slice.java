package com.novbank.data.domain;

import com.google.common.base.Converter;

import java.util.List;

/**
 * Created by CaoKe on 2015/6/21.
 */
public interface Slice <T> extends Iterable<T> {
    int getNumber();

    int getSize();

    int getNumberOfElements();

    List<T> getContent();

    boolean hasContent();

    Sort getSort();

    boolean isFirst();

    boolean isLast();

    boolean hasNext();

    boolean hasPrevious();

    Pageable nextPageable();

    Pageable previousPageable();

    <S> Slice<S> map(Converter<? super T, ? extends S> converter);
}
