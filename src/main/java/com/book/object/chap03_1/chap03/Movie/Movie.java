package com.book.object.chap03_1.chap03.Movie;

import com.book.object.chap03_1.chap03.discount.DiscountCondition;
import com.book.object.chap03_1.chap03.discount.DiscountConditionType;
import com.book.object.chap03_1.chap03.money.Money;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Movie {
    private String title;
    private Duration runningTime;
    private double discountPercent;
    private MovieType movieType;
    private List<DiscountCondition> discountConditions;
    private Money discountAmount;
    private Money fee;

    public MovieType getMovieType() {
        return movieType;
    }

    public String getTitle() {
        return title;
    }

    public Duration getRunningTime() {
        return runningTime;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public List<DiscountCondition> getDiscountConditions() {
        return discountConditions;
    }

    public Money getDiscountAmount() {
        return discountAmount;
    }

    public Money getFee() {
        return fee;
    }

    //    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public Duration getRunningTime() {
//        return runningTime;
//    }
//
//    public void setRunningTime(Duration runningTime) {
//        this.runningTime = runningTime;
//    }
//
//    public double getDiscountPercent() {
//        return discountPercent;
//    }
//
//    public void setDiscountPercent(double discountPercent) {
//        this.discountPercent = discountPercent;
//    }
//
//    public MovieType getMovieType() {
//        return movieType;
//    }
//
//    public void setMovieType(MovieType movieType) {
//        this.movieType = movieType;
//    }
//
//    public List<DiscountCondition> getDiscountConditions() {
//        return discountConditions;
//    }
//
//    public void setDiscountConditions(List<DiscountCondition> discountConditions) {
//        this.discountConditions = discountConditions;
//    }
//
//    public Money getDiscountAmount() {
//        return discountAmount;
//    }
//
//    public void setDiscountAmount(Money discountAmount) {
//        this.discountAmount = discountAmount;
//    }

//    public Money getFee() {
//        return fee;
//    }
//
//    public void setFee(Money fee) {
//        this.fee = fee;
//    }

    public Money calculateAmountDiscountedFee() {
        if (movieType != MovieType.AMOUNT_DISCOUNT) {
            throw new IllegalArgumentException();
        }
        return fee.minus(discountAmount);
    }

    public Money calculatePercentDiscountedFee() {
        if (movieType != MovieType.PERCENT_DISCOUNT) {
            throw new IllegalArgumentException();
        }
        return fee.minus(fee.times(discountPercent));
    }

    public Money calculateNoneDiscountedFee() {
        if (movieType != MovieType.NONE_DISCOUNT) {
            throw new IllegalArgumentException();
        }
        return fee;
    }

    public boolean isDiscountable(LocalDateTime whenScreened , int sequence) {
        for (DiscountCondition condition : discountConditions) {
            if (condition.getType() == DiscountConditionType.PERIOD) {
                if (condition.isDiscountable(whenScreened.getDayOfWeek(),whenScreened.toLocalTime())) {
                    return true;
                } else {
                    if (condition.isDiscountable(sequence)) {
                        return true;
                    }
                }
            }

        }
        return false;
    }
}
