package com.book.object.chap02.screening;

import com.book.object.chap02.customer.Customer;
import com.book.object.chap02.money.Money;
import com.book.object.chap02.movie.Movie;
import com.book.object.chap02.reservation.Reservation;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public Reservation reserve(Customer customer , int audienceCount) {
        return new Reservation(customer , this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return null;
    }

}
