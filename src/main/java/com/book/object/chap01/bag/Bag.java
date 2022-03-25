package com.book.object.chap01.bag;

import com.book.object.chap01.invitation.Invitation;
import com.book.object.chap01.ticket.Ticket;

public class Bag {
    private Long money;
    private Invitation invitation;
    private Ticket ticket;

    public Long hold(Ticket ticket) {
        if (hasInvitation()) {
            setTicket(ticket);
            return 0L;
        } else {
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }

    /*
    * 초대장 소유여부 판단
    * */
    private boolean hasInvitation() {
        return invitation != null;
    }


    /**
     * 초대장을 티켓으로 교환한다
     * @param ticket
     */
    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    /**
     * 현금 차감
     */
    private void minusAmount(Long money) {
        this.money -= money;
    }

    /**
     * 현금 총액
     */
    public void plusMoney(Long money) {
        this.money += money;
    }

}
