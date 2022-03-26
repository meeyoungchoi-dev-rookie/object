package com.book.object.chap02.discount.condition;

import com.book.object.chap02.screening.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
