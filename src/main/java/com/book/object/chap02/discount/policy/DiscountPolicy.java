package com.book.object.chap02.discount.policy;

import com.book.object.chap02.discount.condition.DiscountCondition;
import com.book.object.chap02.money.Money;
import com.book.object.chap02.screening.Screening;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {

    private List<DiscountCondition> conditions = new ArrayList<>();

    public DiscountPolicy(DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition condition : conditions) {
            if (condition.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }


    abstract protected Money getDiscountAmount(Screening screening);


}
