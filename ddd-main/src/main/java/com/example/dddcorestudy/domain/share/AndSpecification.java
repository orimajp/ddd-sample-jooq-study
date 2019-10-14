package com.example.dddcorestudy.domain.share;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AndSpecification<T> implements Specification<T> {

    private final Specification<T> spec1;
    private final Specification<T> spec2;

    /**
     * Check if {@code t} is satisfied by the specification.
     *
     * @param t Object to test.
     * @return {@code true} if {@code t} satisfies the specification.
     */
    @Override
    public boolean isSatisfiedBy(final T t) {
        return spec1.isSatisfiedBy(t) && spec2.isSatisfiedBy(t);
    }

}
