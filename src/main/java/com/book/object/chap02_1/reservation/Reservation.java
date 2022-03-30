package com.book.object.chap02_1.reservation;

import com.book.object.chap02_1.customer.Customer;
import com.book.object.chap02_1.money.Money;
import com.book.object.chap02_1.screening.Screening;

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
