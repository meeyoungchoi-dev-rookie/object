package com.book.object.chap02_1.discount.policy;

import com.book.object.chap02_1.discount.condition.DiscountCondition;
import com.book.object.chap02_1.money.Money;
import com.book.object.chap02_1.screening.Screening;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {

    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
