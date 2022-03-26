package com.book.object.chap02.movie;


import com.book.object.chap02.discount.policy.DiscountPolicy;
import com.book.object.chap02.money.Money;
import com.book.object.chap02.screening.Screening;

public class Movie {

    private String title;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return null;
    }

}
