package com.book.object.chap03_1.chap03.Movie;

import com.book.object.chap03_1.chap03.discount.DiscountCondition;
import com.book.object.chap03_1.chap03.discount.DiscountConditionType;
import com.book.object.chap03_1.chap03.money.Money;
import com.book.object.chap03_1.chap03.screening.Screening;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public abstract class Movie {
    private String title;
    private Duration runningTime;
    private List<DiscountCondition> discountConditions;
    private Money fee;

    public Movie(String title, Duration runningTime, List<DiscountCondition> discountConditions, Money fee) {
        this.title = title;
        this.runningTime = runningTime;
        this.discountConditions = discountConditions;
        this.fee = fee;
    }

    public String getTitle() {
        return title;
    }

    public Duration getRunningTime() {
        return runningTime;
    }


    public List<DiscountCondition> getDiscountConditions() {
        return discountConditions;
    }


    public Money getFee() {
        return fee;
    }


   public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }

        return fee;
   }

    public boolean isDiscountable(Screening screening) {
        return discountConditions.stream().anyMatch(discountCondition -> discountCondition.isSatisfiedBy(screening));
    }

    protected abstract Money calculateDiscountAmount();
}
