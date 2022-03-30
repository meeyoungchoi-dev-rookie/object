package com.book.object.chap02_1.discount.policy;

import com.book.object.chap02_1.money.Money;
import com.book.object.chap02_1.screening.Screening;

public class NoneDiscountPolicy implements DiscountPolicy{

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
