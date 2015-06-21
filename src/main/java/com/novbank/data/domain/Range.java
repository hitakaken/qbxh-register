package com.novbank.data.domain;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by CaoKe on 2015/6/21.
 */
public class Range <T extends Comparable<T>> {
    private final T lowerBound;
    private final T upperBound;
    private final boolean lowerInclusive;
    private final boolean upperInclusive;

    public Range(T lowerBound, T upperBound) {
        this(lowerBound, upperBound, true, true);
    }

    public Range(T lowerBound, T upperBound, boolean lowerInclusive, boolean upperInclusive) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.lowerInclusive = lowerInclusive;
        this.upperInclusive = upperInclusive;
    }

    public T getLowerBound() {
        return this.lowerBound;
    }

    public T getUpperBound() {
        return this.upperBound;
    }

    public boolean contains(T value) {
        checkNotNull(value, "Reference value must not be null!");
        boolean greaterThanLowerBound = this.lowerBound == null?true:(this.lowerInclusive?this.lowerBound.compareTo(value) <= 0:this.lowerBound.compareTo(value) < 0);
        boolean lessThanUpperBound = this.upperBound == null?true:(this.upperInclusive?this.upperBound.compareTo(value) >= 0:this.upperBound.compareTo(value) > 0);
        return greaterThanLowerBound && lessThanUpperBound;
    }
}
