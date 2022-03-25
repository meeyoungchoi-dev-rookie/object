package com.book.object.chap02.reservation;

import com.book.object.chap02.customer.Customer;
import com.book.object.chap02.money.Money;
import com.book.object.chap02.screening.Screening;

public class Reservation {
    private Customer customer;
    private Screening screening;
    private Money fee;
    private int audienceCount;

    public Reservation(Customer customer, Screening screening, Money fee, int audienceCount) {
        this.customer = customer;
        this.screening = screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }
}
