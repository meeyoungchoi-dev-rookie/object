package com.book.object.chap03_1.chap03.reservation;


import com.book.object.chap03_1.chap03.customer.Customer;

import com.book.object.chap03_1.chap03.money.Money;
import com.book.object.chap03_1.chap03.screening.Screening;

public class ReservationAgency {

    public Reservation reserve(Screening screening, Customer customer , int audienceCount) {
        Money fee = screening.calculateFee(audienceCount);
        return new Reservation(customer , screening , fee, audienceCount);
    }


}
