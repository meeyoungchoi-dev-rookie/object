package com.book.object.chap02_1.discount.condition;

import com.book.object.chap02_1.screening.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}

