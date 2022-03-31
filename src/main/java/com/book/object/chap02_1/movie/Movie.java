package com.book.object.chap02_1.movie;

import com.book.object.chap02_1.discount.policy.NoneDiscountPolicy;
import com.book.object.chap02_1.money.Money;
import com.book.object.chap02_1.screening.Screening;

public class Movie {

    private String title;
    private Money fee;
    private NoneDiscountPolicy noneDiscountPolicy;

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(noneDiscountPolicy.calculateDiscountAmount(screening));
    }
}
