package com.book.object.ticketseller;

import com.book.object.audience.Audience;
import com.book.object.office.TicketOffice;


public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience) {
        ticketOffice.plusMoney(audience.buy(ticketOffice.getTicket()));
    }
}
