# 01 객체 , 설계
## 티켓 애플리케이션 클래스 관계도
![티켓애플리케이션_클래스_구조도](https://user-images.githubusercontent.com/42866800/159278715-8764a9da-70aa-48c5-a95e-fab672269056.png)

## 클래스간 의존성이 높을 때 문제점
+ 두 객체 사이의 결합도가 높으면 함께 변경될 확률도 높아지기 때문에 변경하기 어려워진다
+ 객체 사이의 결합도를 낮춰 변경이 용이한 설계를 만들어야 한다
+ [티켓 애플리케이션 무엇이 문제인가](https://unique-wandflower-4cc.notion.site/02-ed75306865e84c49aceb9a20cac5b22e)

## 티켓 애플리케이션 구조 개선
### 무엇이 문제인가
- Bag 객체는 자기 자신을 스스로 책임지지 않고 Audience 객체에 끌려다니는 수동적인 존재이다
- TicketOffice는 스스로 티켓을 관리하지 못하고 TicketSeller 객체에 의존하고 있다
### 무엇이 개선되었는가
- Audience는 자신의 Bag을 직접 관리한다
- TicketSeller는 직접 Ticket을 관리한다
- Audience와 TicketSeller의 내부 구현이 변경되어도 Theater를 함께 변경할 필요가 없다
- Audience가 작은 지갑을 소유하도록 코드를 변경하거나
- TicketSeller가 은행에 돈을 보관하도록 보관하려면 Audience 클래스와 TickeSeller 클래스 내부만 변경하면 된다
- 따라서 수정된 코드는 읽는 사람과의 의사소통과 변경 용이성이 확실히 개선되었다
#### 객체지향적 설계가 중요한 이유
+ 캡슐화를 사용하여 객체 내부 로직을 감춘다
+ 외부에서 객체 내부에 직접 접근할 수 없게 처리
- 객체들 사이의 의존성을 적절하게 조절
- [설계 개선하기](https://unique-wandflower-4cc.notion.site/03-051818a439fa47a3bcf50b2cd804fb7e)

------------------------------------------------------------------------
# 영화 얘매시스템
## 요구사항
- 영화 얘매 시스템을 이용해 쉽고 빠르게 보고 싶은 영화를 얘매
- `영화` - 영화에 대한 기본 정보 표현
- `상영` - 실제로 관객들이 영화를 관람하는 사건을 표현
- 상영일자 , 시간 , 순번을 가리킨다
- 하나의 영화는 하루 중 다양한 시간대에 걸쳐 한번이상 상영될 수 있다
- [영화 얘매 시스템](https://unique-wandflower-4cc.notion.site/01-5d84df99c61c4f9b85937ebb7b9e8120)

## 할인 금액을 결정하는 두 가지조건
### 할인조건
- `순서 조건`
- 상영 순번을 사용하여 할인 여부 결정
- `기간 조건`
- 영화 상영 시작 시간을 이용해 할인 여부 결정
- 요일 , 시작시간,  종료시간 세부분으로 구성된다
- 영화 시작 시간이 해당 기간 안에 포함될 경우 요금을 할인한다
- 다수의 할인 조건을 함께 지정할 수 있다
- 순서 조건과 기간 조건을 섞는 것도 가능
### 할인정책
- 할인 요금을 결정
- `금액 할인 정책`
- 얘매 요금에서 일정 금액을 할인해 주는 방식
- `비율 할인 정책`
- 정가에서 일정 비율의 요금을 할인해 주는 방식
- [할인 조건과 할인 정책](https://unique-wandflower-4cc.notion.site/03-6e53c55a2ef54dae994466a1405db07d)

# 객체간 협력
## 협력
- 시스템의 기능을 구현하기 위해 객체들 사이에 이루어지는 상호작용
- 협력의 관점에서 어떤 객체가 필요한지 결정하고 객체들의 공통 상태와 행위를 구현 하기위한 클래스 설계

## 퍼블릭 인터페이스 와 구현
- 퍼블릭 인터페이스 - 외부에서 접근 가능한 부분
- 구현 - 외부에서 접근 불가능하고 오직 내부에서만 접근 가능한 부분

- 퍼블릭 인터페이스를 통해 객체의 내부 상태에 접근할 수 있다

## 메시지 전송
- 객체가 다른 객체와 상호작용할 수 있는 방법
- `메시지 수신` - 다른 객체에게 요청이 도착했을때 해당 객체가 메시지를 수신한다
- `메서드` - 수신된 메시지를 처리하기 위한 방법

## 메시지와 메서드 구분

- 메시지와 메서드를 구분함으로써 다형성 이라는 개념이 출발한다

```TEXT
Screening이 Movie의 calculateMovieFee 메서드를 호출한다 (x)
Screening이 Movie에게 calculateMovieFee 메시지를 전송한다 (o)

Screening 객체는 Movie 객체 안에 calculateMovieFee 메서드가 존재하고 있는지 조차 알지 못한다
Movie 객체가 calculateMovieFee 메시지에 응답할 수 있다고 믿고 메시지를 전송할 뿐이다

메시지를 수신한 Movie 객체는 스스로 적절한 메서드를 선택한다
```
## 결론
- 협력의 관점에서 어떤 객체가 필요한지 결정해야 한다
- 객체들의 공통 상태와 행위를 구현하기 위해 클래스를 작성한다
- 객체는 메시지를 전송하고 수신함으로써 상호작용한다
- 메서드는 객체가 메시지를 처리하기 위한 방법이다
- [협력 , 객체 , 클래스](https://unique-wandflower-4cc.notion.site/02-8e3b03139d7b4c2ea4291c8cecb56db8)


---------------------------------------------------------
# 다형성 과 추상화
![할인 정책과 할인 조건에 적용된 다형성](https://user-images.githubusercontent.com/42866800/160417005-0e636c58-bd17-46a0-8215-4d8023f7bbdf.png)
- 동일한 메시지를 수신했을 때 객체의 타입에 따라 다르게 응답할 수 있는 능력
- 인터페이스가 동일해야 한다
- AmountDiscountPolicyy 와 PercentdiscountPolicy가 다형성이 적용될 수 있는 이유
- 동일한 DiscountPolicy 인터페이스를 물려받았기 때문이다
- 다형성은 컴파일 시간 의존성과 실행 시간 의존성을 다르게 만들 수 있다



## 상속
- 상속을 사용하면 부모 클래스가 제공하는 모든 인터페이스를 자식 클래스가 물려받을 수 있다
- 왜?
- 상속 관계시 자식 클래스는 부모 클래스의 모든 메시지를 수신할 수 있기 때문
- 따라서 자식 클래스는 부모 클래스와 동일한 타입으로 해석될 수 있다
## 코드 재사용
- 상속은 코드를 재사용하기 위한 방법이다
- 하지만 코드를 재사용하기 위해 상속 보단 합성(composition)이 더 좋은 방법이다

## 합성을 사용하면
- 인터페이스와 약하게 결합된다
- 즉 , 인터페이스에 정의된 메시지를 통해 코드를 재사용할 수 있다
- 구현을 효과적으로 캡슐화 할 수 있다
- 의존하는 객체를 교체하는 것이 쉽다

## 인터페이스
- 구현은 공유할 필요가 없고 인터페이스만 공유하고 싶은 경우
- 인터페이스를 구현한 클래스에도 업캐스팅이 적용되어 다형적으로 협력할 수 있다
- DiscountCondition 인터페이스를 실체화 하고 있는 SequenceCondition과 PeriodCondition은 동일한 인터페이스를 공유한다
- 즉 , DiscountCondition 을 대신해서 사용될 수 있다
- ![할인조건에 적용된 인터페이스와 다형성](https://user-images.githubusercontent.com/42866800/160417538-0782a1af-2932-41de-b602-066f4fed040e.png)

## 추상화의 힘
- 추상화를 사용하면 설계가 더 유연해 진다
- 기존 구조를 수정하지 않고 새로운 기능을 쉽게 추가할 수 있다

## 추상 클래스와 인터페이스 트레이드오프
- 구현과 관련된 것은 트레이드오프의 대상이 된다
### `트레이드오프`
1. 변경의 정도에 따라 구현과 인터페이스를 분리
2. 외부에서는 인터페이스에만 의존하도록 설계 조절
3. 높은 응집도와 낮은 결합도를 가진 설계가 변경하기 쉽다
4. 응집도 - 모듈 내부에서 발생하는 변경의 정도
5. 결합도 - 의존성의 정도
- AmountDiscountPolicy 와 PercentDiscountPolicy 클래스가 공통으로 가지는 메서드를 추상클래스에 선언하고
- 할인 조건별 금액을 계산하는 메서드는 추상 메서드로 선언하여 각 할인 조건에서 오버라이딩 하여 내부를 구현할 수 있게 했다
- 즉 추상클래스에 선언된 getDiscountAmount 메서드를 각 할인 정책별로 오버라이딩 하여 기능을 확장해 나간다

### 할인 정책과 할인 조건
![할인 정책과 할인 조건 클래스 관계](https://user-images.githubusercontent.com/42866800/160238264-05139421-c022-4cdd-b42a-5e3fdd6d0386.png)

할인 정책은 금액 할인 정책과 비율 할인 정책으로 구분된다
![할인정책_클래스_구조도](https://user-images.githubusercontent.com/42866800/160238280-6528d8da-c845-4a5e-9c37-5e07c2f97e30.png)

할인조건은 인터페이스로 구현한다
순번 조건과 기간 조건이 존재한다
![할인조건_클래스 구조도](https://user-images.githubusercontent.com/42866800/160238308-e71ac56b-5b93-4598-aa5b-f2d74712edee.png)

## 결론
+ 다형성을 통해 동일한 인터페이스를 공유하는 클래스를 하나의 타입으로 묶을수 있다
+ 다형성의 지연바인딩을 통해 메시지에 응답하기 위한 메서드를 실행시점에 결정한다
+ 인터페이스를 추상화 하여 응집도는 높이고 결합도는 낮춘다
+ 합성을 사용하여 구현을 캡슐화 하고 결합도는 낮춘다
+ [상속과 다형성](https://www.notion.so/04-8fafab2ddea94b208b6069cd1a607cd8)
+ [추상화와 유연성](https://www.notion.so/05-391c69b440ab40d9b9d7d4e773c7b470)

--------------------------------------------------------
# 객체지향 패러다임의 관점에서 핵심
- 역할
- 책임
- 협력

## 자율적인 객체를 만드는 방법
- 필요한 정보와 행동을 같은 객체 안에 모아둬야 한다
- 자신이 할 수 없는 일을 다른 객체에게 위임한다
- 내부 구현을 캡슐화 한다
- 변경에 대한 파급 효과를 줄여 변경을 용이하게 해준다


## 메시지 전송
- 메시지 전송은 객체 사이의 협력을 위해 사용하는 유일한 커뮤니케이션 수단이다
- 객체가 다른 객체의 내부 구현에 직접 접근할 수 없다
- 따라서 메시지 전송을 통해서만 자신의 요청을 전달한다
- 한 객체는 어떤 것이 필요할 때 다른 객체에게 전적으로 위임하거나 서로 협력한다


## 협력이 설계를 위한 문맥을 결정한다
- 객체가 참여하고 있는 협력이 객체의 행동을 결정한다
- 행동은 객체의 상태를 결정한다
- 협력이 객체를 구성하는 행동과 상태를 모두 결정한다
- 협력이 바뀌면 객체가 제공해야 하는 행동도 바뀌어야 한다


# 책임이란 무엇인가
- 협력에 참여하기 위해 객체가 수행하는 행동
- 객체가 `무엇을 알고있는가`  `무엇을 할 수 있는가` 로 구성된다

`하는 것`

- 객체 생성 및 계산 수행
- 다른 객체의 행동을 시작시킨다
- 다른 객체의 행동을 제어 및 조절

`아는 것`

- 사적인 정보에 대해 아는 것
- 관련된 객체에 관해 아는 것
- 유도하거나 계산할 수 있는 것에 대해 아는 것

## 책임과 메시지
- 책임은 여러개의 메시지로 분할 될 수 있다
- 하나의 객체가 수행할 수 있다고 생각한 책임이 여러 객체들이 협력해야 하는 책임으로 자라기도 한다

## 객체의 책임
- 협력 안에서 객체에게 할당한 책임이 외부의 인터페이스와 내부의 속성을 결정한다
- 적절한 책임을 적절한 객체에게 할당해야 단순하고 유연한 설계가 된다

## 책임을 할당하는 방법
+ 협력에 필요한 메시지를 찾고 메시지가 적절한 객체를 선택하는 과정이 반복된다
+ 메시지를 수신할 객체의 책임이 결정된다
+ 메시지는 인터페이스로 구성된다

## 책임 주도 설계 (Responsibility Driven Design)
- 책임을 찾고 책임을 수행할 적절한 객체를 찾아 책임을 할당하는 방식으로 협력을 설계하는 방법
- 협력은 객체를 설계하기 위한 구체적인 문맥을 제공한다
- 협력이 책임을 이끌어 내고 책임이 협력에 참여할 객체를 결정한다

**책임 주도 설계 과정**
- 시스템이 제공해야 하는 기능인 시스템 책임 파악
- 시스템 책임을 더 작은 책임으로 분할
- 책임을 수행할 수 있는 객체 또는 역할을 찾아 책임 할당
- 객체가 책임을 수행하는 중 다른 객체의 도움이 필요할 경우 이를 책임질 적절한 객체 또는 역할을 찾는다
- 해당 객체 또는 역할에게 책임을 할당한다
- 두 객체가 협력하게 된다

## 결론
+ 객체가 책임을 가지면 꼭 필요한 인터페이스만을 갖게 된다
+ 인터페이스는 추상화 되있기 때문에 구현은 캡슐화 할 수 있다
+ 즉 인터페이스 내부가 어떻게 동작하는지 신경쓰지 않아도 된다
+ [객체의 역할](https://unique-wandflower-4cc.notion.site/03-4a4a1229fd424e8bbb71bc73c762dd24)
+ [객체의 책임](https://unique-wandflower-4cc.notion.site/02-07d2ac53f7fe4fe196b0ca280a773812)


# 역할과 협력
## 역할
+ 객체가 특정 협력 안에서 수행하는 책임의 집합
## 유연하고 재사용가능한 협력
+ 역할을 통해 객체를 하나로 통합할 수 있다
+ 협력안에서 역할에 따라 객체를 바꿔 끼울수 있다

## 역할과 추상화
<aside>
📌 역할을 사용하여 협력안에서 동일한 책임을 수행하는 객체를 추상화 할 수 있다
</aside>
![역할은 협력을 추상화 한다](https://user-images.githubusercontent.com/42866800/161234185-166acc8b-ad8a-4f2c-b0ea-67e3d59d3818.png)
- 구체적인 객체로 대체 가능한 DiscountPolicy 와 DiscountCondition이 역할이다
- 역할을 사용하면 협력안에서 동일한 책임을 수행하는 객체를 추상화 할 수 있다

![영화 얘매 요금을 계산하는데 필요한 할인 정책과 할인 조건의 구조](https://user-images.githubusercontent.com/42866800/161234061-606a8a74-a244-4c9f-96c1-53493c4f3e0a.png)

추상화를 통해 할인 정책과 할인 조건이 조합되어 영화 얘매 금액이 결정되는 것을 알 수 있다
![할인 정책와 할인 조건에 대한 추상화는 객체들 사이의 관계를 파악하는데 유용하다](https://user-images.githubusercontent.com/42866800/161234137-2d4916dc-0cd1-424c-93ea-a471a8b5f1f1.png)
구체적인 할인 정책의 종류를 추상화한 DiscountPolicy 추상 클래스와 할인 조건의 종류를 추상화한 DiscountCondition 인터페이스를 통해 협력을 표현

DiscountPolicy와 DiscountCondition 역할을 수행할 수 있는 객체라면 얘매 요금 계산 협력에 참여할 수 있다

구체적인 할인 정책과 할인 조건이 DiscountPolicy와 DiscountCondition을 대체할 것이다

협력 안에서 동일한 책임을 수행하는 객체들은 동일한 역할을 수행하기 때문에 대체 가능하다

역할은 다양한 환경에서 다양한 객체들을 수용할 수 있게 도와주므로 협력을 유연하게 만들어준다

## 결론
+ 객체가 동일한 책임을 갖는 경우 역할을 추상화 할 수 있다
+ 역할은 추상클래스와 인터페이스를 통해 추상화 될 수 있다
+ 추상화를 통해 협력안에서 자유롭게 객체를 갈아끼울수 있다