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
        if (audience.getBag().hasInvitation()) {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);
        } else {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusMoney(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
}
