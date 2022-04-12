package com.book.object.chap03_1.chap03.Movie;

import com.book.object.chap03_1.chap03.discount.DiscountCondition;
import com.book.object.chap03_1.chap03.money.Money;

import java.time.Duration;
import java.util.List;

public class PercentDiscountAmountMovie extends Movie{

    private double percent;

    public PercentDiscountAmountMovie(String title, Duration runningTime, List<DiscountCondition> discountConditions, Money fee , double percent) {
        super(title, runningTime, discountConditions, fee);
        this.percent = percent;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return getFee().times(percent);
    }
}
