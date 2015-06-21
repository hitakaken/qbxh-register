package com.novbank.data.domain;

import com.google.common.base.Converter;

import java.util.List;

/**
 * Created by CaoKe on 2015/6/21.
 */
public class SliceImpl<T> extends Chunk<T>  {
    private final boolean hasNext;
    private final Pageable pageable;

    /**
     * Creates a new {@link Slice} with the given content and {@link Pageable}.
     *
     * @param content the content of this {@link Slice}, must not be {@literal null}.
     * @param pageable the paging information, can be {@literal null}.
     * @param hasNext whether there's another slice following the current one.
     */
    public SliceImpl(List<T> content, Pageable pageable, boolean hasNext) {

        super(content, pageable);
        this.hasNext = hasNext;
        this.pageable = pageable;
    }

    /**
     * Creates a new {@link SliceImpl} with the given content. This will result in the created {@link Slice} being
     * identical to the entire {@link List}.
     *
     * @param content must not be {@literal null}.
     */
    public SliceImpl(List<T> content) {
        this(content, null, false);
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Slice#hasNext()
     */
    public boolean hasNext() {
        return hasNext;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Slice#transform(org.springframework.core.convert.converter.Converter)
     */
    @Override
    public <S> Slice<S> map(Converter<? super T, ? extends S> converter) {
        return new SliceImpl<S>(getConvertedContent(converter), pageable, hasNext);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        String contentType = "UNKNOWN";
        List<T> content = getContent();

        if (content.size() > 0) {
            contentType = content.get(0).getClass().getName();
        }

        return String.format("Slice %d containing %s instances", getNumber(), contentType);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof SliceImpl<?>)) {
            return false;
        }

        SliceImpl<?> that = (SliceImpl<?>) obj;

        return this.hasNext == that.hasNext && super.equals(obj);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        int result = 17;

        result += 31 * (hasNext ? 1 : 0);
        result += 31 * super.hashCode();

        return result;
    }
}
