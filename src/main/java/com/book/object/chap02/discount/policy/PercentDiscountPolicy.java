package com.book.object.chap02.discount.policy;

import com.book.object.chap02.discount.condition.DiscountCondition;
import com.book.object.chap02.money.Money;
import com.book.object.chap02.screening.Screening;

public class PercentDiscountPolicy extends DiscountPolicy{

    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return null;
    }
}
