package com.book.object.chap02_1.discount.policy;


import com.book.object.chap02_1.money.Money;
import com.book.object.chap02_1.screening.Screening;

interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
