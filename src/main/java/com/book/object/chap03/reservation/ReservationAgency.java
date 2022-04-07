package com.book.object.chap03.reservation;

import com.book.object.chap03.Movie.Movie;
import com.book.object.chap03.customer.Customer;
import com.book.object.chap03.discount.DiscountCondition;
import com.book.object.chap03.discount.DiscountConditionType;
import com.book.object.chap03.money.Money;
import com.book.object.chap03.screening.Screening;

public class ReservationAgency {

    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {

        Movie movie = screening.getMovie();

        boolean discountable = false;
        for (DiscountCondition discountCondition : movie.getDiscountConditions()) {
            if (discountCondition.getType() == DiscountConditionType.PERIOD) {
                discountable = screening.getWhenScreened().getDayOfWeek().equals(discountCondition.getDayOfWeek()) &&
                        discountCondition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
                        discountCondition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;

            } else  {
                discountable = discountCondition.getSequence() == screening.getSequence();
            }

            if (discountable) {
                break;
            }
        }


        Money fee;

        if (discountable) {
            Money discountAmount = Money.ZERO;
            switch (movie.getMovieType()) {
                case AMOUNT_DISCOUNT:
                    discountAmount = movie.getDiscountAmount();
                    break;
                case PERCENT_DISCOUNT:
                    discountAmount = movie.getFee().times(movie.getDiscountPercent());
                    break;
                case NONE_DISCOUNT:
                    discountAmount = Money.ZERO;
                    break;
            }

            fee = movie.getFee().minus(discountAmount);
        } else {
            fee = movie.getFee();
        }

        return new Reservation(customer , screening , fee , audienceCount);

    }
}
