package com.book.object.chap01.audience;

import com.book.object.chap01.bag.Bag;
import com.book.object.chap01.ticket.Ticket;

public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Long buy(Ticket ticket) {
        return bag.hold(ticket);
    }
}
