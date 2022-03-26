package com.book.object.chap02.discount.policy;

import com.book.object.chap02.discount.condition.DiscountCondition;
import com.book.object.chap02.money.Money;
import com.book.object.chap02.screening.Screening;

public class AmountDiscountPolicy extends DiscountPolicy{

    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
