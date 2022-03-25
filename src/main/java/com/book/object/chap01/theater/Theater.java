package com.book.object.chap01.theater;

import com.book.object.chap01.audience.Audience;
import com.book.object.chap01.ticketseller.TicketSeller;

public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        ticketSeller.sellTo(audience);
    }
}
