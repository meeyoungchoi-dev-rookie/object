package com.book.object.chap02_1.discount.policy;

import com.book.object.chap02_1.discount.condition.DiscountCondition;
import com.book.object.chap02_1.money.Money;
import com.book.object.chap02_1.screening.Screening;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {

    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return discountAmount;
    }

}
