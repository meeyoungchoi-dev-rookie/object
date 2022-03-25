package com.book.object.chap01.ticketseller;

import com.book.object.chap01.audience.Audience;
import com.book.object.chap01.office.TicketOffice;


public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience) {
        ticketOffice.sellTicketTo(audience);
    }
}
