package com.book.object.chapter06;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class EventTest {

    @Test
    void checkEvent() {
        // 5월 8일에 10시 30분 부터 11시 까지 열리는 회의 객체 생성
        Event meeting = new Event("회의", LocalDateTime.of(2022, 5, 4, 10 ,30), Duration.ofMinutes(30));

        // 매주 수요일 10시 30분 부터 30분 동안 열리는 회의 객체 생성 - 반복일정 (RecurringSchedule 객체)
        RecurringSchedule schedule = new RecurringSchedule("회의", DayOfWeek.WEDNESDAY, LocalTime.of(10, 30), Duration.ofMinutes(30));

        Assertions.assertThat(meeting.isSatisfied(schedule)).isEqualTo(true);
    }

    @Test
    void checkEvent2() {
        RecurringSchedule schedule = new RecurringSchedule("회의", DayOfWeek.WEDNESDAY, LocalTime.of(10, 30), Duration.ofMinutes(30));
        Event meeting = new Event("회의", LocalDateTime.of(2022, 5, 5, 10, 30), Duration.ofMinutes(30));


        Assertions.assertThat(meeting.isSatisfied(schedule)).isEqualTo(false);
        Assertions.assertThat(meeting.isSatisfied(schedule)).isEqualTo(true);

    }
}
