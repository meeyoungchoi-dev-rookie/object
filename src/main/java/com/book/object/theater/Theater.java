package com.book.object.theater;

import com.book.object.audience.Audience;
import com.book.object.ticket.Ticket;
import com.book.object.ticketseller.TicketSeller;

public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        ticketSeller.sellTo(audience);
    }
}
