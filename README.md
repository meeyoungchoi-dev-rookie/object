# 오브젝트

## 01 객체 , 설계
+ [티켓 판매 애플리케이션](https://unique-wandflower-4cc.notion.site/01_1-ace7774eb70d4750b75422b5843947d7)

### 클래스 관계도
![티켓애플리케이션_클래스_구조도](https://user-images.githubusercontent.com/42866800/159278715-8764a9da-70aa-48c5-a95e-fab672269056.png)


### 클래스 흐름
- 이벤트 당첨자는 초대장을 갖고 있다
- 공연을 관람하기 위해 티켓을 갖고 있어야 한다
- 이벤트 당첨자는 초대장을 티켓으로 교환할 수 있다
- 이벤트에 당첨되지 않은 사람은 티켓을 살 현금을 갖고 있다
- 관람객이 소지품을 가방에 담아온다
    - 가방에는 초대장 , 현금, 티켓 이 들어있다
- 관람객이 소극장에 입장 하기전 매표소에 들른다
    - 매표소에서 초대장을 티켓으로 교환하거나
    - 티켓을 구매해야 한다
    - 매표소는 관람객에게 판매할 티켓과 티켓의 판매 금액을 보관해야 한다
- 판매원이 매표소에서 초대장이 있는 경우 티켓을 관람객에게 준다
- 판매원은 관람객이 초대장이 없다면 티켓을 판매한다

### 클래스간 의존성이 높을 때 문제점
+ 두 객체 사이의 결합도가 높으면 함께 변경될 확률도 높아지기 때문에 변경하기 어려워진다
+ 하나의 메서드에서 너무 많은 세부사항을 다루기 때문에 코드를 작성하는 사람뿐 아니라 코드를 읽고 이해해야 하는 사람 모두에게 부담을 준다
+ 가정이 깨지는 순간 코드가 흔들리게 된다
+ 객체 사이의 결합도를 낮춰 변경이 용이한 설계를 만들어야 한다
+ [티켓 애플리케이션 무엇이 문제인가](https://unique-wandflower-4cc.notion.site/02-ed75306865e84c49aceb9a20cac5b22e)



### 티켓 애플리케이션 구조 개선
### 캡슐화를 사용하여 객체 내부 로직을 감춘다
+ 외부에서 객체 내부에 직접 접근할 수 없게 처리
### 무엇이 개선되었는가
- Audience는 자신의 Bag을 직접 관리한다
- TicketSeller는 직접 Ticket을 관리한다
- Audience와 TicketSeller의 내부 구현이 변경되어도 Theater를 함께 변경할 필요가 없다
- Audience가 작은 지갑을 소유하도록 코드를 변경하거나
- TicketSeller가 은행에 돈을 보관하도록 보관하려면 Audience 클래스와 TickeSeller 클래스 내부만 변경하면 된다
- 따라서 수정된 코드는 읽는 사람과의 의사소통과 변경 용이성이 확실히 개선되었다

`Bag`

- Bag 객체는 자기 자신을 스스로 책임지지 않고 Audience 객체에 끌려다니는 수동적인 존재이다
- Bag의 내부 상태에 접근하는 로직을 Bag 안으로 캡슐화 하여 결합도를 낮춘다
- Bag을 자율적인 존재로 바꾸기 위해 Bag의 내부상태 로직을 hold 메서드로 감싸 Bag 안으로 캡슐화 한다
- Audience가 Bag 인터페이스에만 의존하도록 코드 수정
- `수정 전`

```java

public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Long buy(Ticket ticket) {
        if (bag.hasInvitation()) {
            bag.setTicket(ticket);
            return 0L;
        } else {
            bag.setTicket(ticket);
            bag.minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }
}
```

- `수정 후`
- Bag객체가 스스로 초대장을 꺼내서 티켓으로 교환한다
- 초대장이 없는 경우 티켓을 구매한다
- Audience 객체는 Bag 객체의 hold 메서드에게 역할을 위임한다

```java

public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Long buy(Ticket ticket) {
        return bag.hold(ticket);
    }
}
```

```java

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
```

`TicketSeller`

- TicketOffice는 스스로 티켓을 관리하지 못하고 TicketSeller 객체에 의존하고 있다

```java

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience) {
        ticketOffice.plusMoney(audience.buy(ticketOffice.getTicket()));
    }
}
```

- TicketSeller가 TicketOffice에 있는 티켓을 마음대로 꺼내 Audience에 팔고 받은 돈을 마음대로 TicketOffice에 넣어버린다
- TicketSeller로 부터 의존성을 제거

```java

public class TicketOffice {
    private Long money;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long money, Ticket ... tickets) {
        this.money = money;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    public void sellTicketTo(Audience audience) {
        plusMoney(audience.buy(getTicket()));
    }

    private Ticket getTicket() {
        return tickets.remove(0);
    }

    public void minusMoney(Long money) {
        this.money -= money;
    }

    private void plusMoney(Long money) {
        this.money += money;
    }
}
```

- TicketOffice에 sellTicketTo 메서드 추가
- TicketSeller가 티켓을 판매하고 관리하는 코드를 sellTicketTo 메서드로 옮긴다
- 티켓을 판매한 돈을 관리하는 메서드의 접근제한자를 private으로 변경하고 외부에서 직저버 티켓을 관리할 수 없게 한다
- 즉 , 티켓관리와 판매는 TicketOffice 내부에서만 할 수 있게 되었다
- TicketSeller는 TicketOffice의 sellTicketTo 메서드를 호출하여 티켓 관리와 판매 역할을 위임한다
- TicketSeller는 TicketOffice의 인터페이스에만 의존하게 된다
- 상세 구현내용은 TicketOffice 내부로 감췄다

### 절차적 프로그램의 문제점
- 사람의 직관에 위배된다
- 데이터의 변경으로 인한 영향을 지역적으로 고립시키기 어렵다
- Audience와 TicketSeller의 내부를 변경하려면 Theater 클래스의 enter 메서드도 변경해야 한다
- 변경은 버그를 부르고 버그에 대한 두려움은 코드를 변경하기 어렵게 만든다

### 변경하기 쉬운 설계
- 한번에 하나의 클래스만 변경할 수 있는 설계
- 절차적 프로그래밍은 프로세스가 필요한 모든 데이터에 의존해야 하므로 변경에 취약할 수 밖에 없다
- `해결방법`
- 자신의 데이터를 스스로 처리하도록 프로세스의 단계를 Audience와 TicketSeller로 이동시킨다
- 수정된 코드에서는 데이터를 사용하는 프로세스의 코드가 데이터를 소유하고 있는 Audience와 TicketSeller 클래스 내부로 옮겨졌다
- `객체지향 프로그래밍` - 데이터와 프로세스가 동일한 모듈 내부에 위치하도록 프로그래밍 하는 방식