package com.book.object.chap02.discount.condition;

import com.book.object.chap02.screening.Screening;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class PeriodCondition implements DiscountCondition{

    private DayOfWeek dayOfWeek;
    private LocalTime localTime;
    private LocalTime endTime;

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime localTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.localTime = localTime;
        this.endTime = endTime;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return false;
    }
}
