package com.book.object.bag;

import com.book.object.invitation.Invitation;
import com.book.object.ticket.Ticket;

public class Bag {
    private Long money;
    private Invitation invitation;
    private Ticket ticket;

    public Bag(Long money) {
        this(null, money);
    }

    public Bag(Invitation invitation , Long money) {
        this.invitation = invitation;
        this.money = money;
    }

    /*
    * 초대장 소유여부 판단
    * */
    public boolean hasInvitation() {
        return invitation != null;
    }

    /**
     * 티켓 소유 여뷰 판단
     *
     * */
    public boolean hasTicket() {
        return ticket != null;
    }

    /**
     * 초대장을 티켓으로 교환한다
     * @param ticket
     */
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    /**
     * 현금 차감
     */
    public void minusAmount(Long money) {
        this.money -= money;
    }

    /**
     * 현금 총액
     */
    public void plusMoney(Long money) {
        this.money += money;
    }


}
