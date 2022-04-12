package com.book.object.chap03_1.chap03.Movie;

import com.book.object.chap03_1.chap03.discount.DiscountCondition;
import com.book.object.chap03_1.chap03.money.Money;

import java.time.Duration;
import java.util.List;

public class AmountDiscountMovie extends Movie {

    private Money discountAmount;

    public AmountDiscountMovie(String title, Duration runningTime, List<DiscountCondition> discountConditions, Money fee, Money discountAmount) {
        super(title, runningTime, discountConditions, fee);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return discountAmount;
    }
}
