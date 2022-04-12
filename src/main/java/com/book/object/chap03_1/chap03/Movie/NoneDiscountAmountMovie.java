package com.book.object.chap03_1.chap03.Movie;

import com.book.object.chap03_1.chap03.discount.DiscountCondition;
import com.book.object.chap03_1.chap03.money.Money;

import java.time.Duration;
import java.util.List;

public class NoneDiscountAmountMovie extends Movie{
    public NoneDiscountAmountMovie(String title, Duration runningTime, List<DiscountCondition> discountConditions, Money fee) {
        super(title, runningTime, discountConditions, fee);
    }

    @Override
    protected Money calculateDiscountAmount() {
        return Money.ZERO;
    }
}
