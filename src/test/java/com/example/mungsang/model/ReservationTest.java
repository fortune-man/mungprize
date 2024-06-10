package com.example.mungsang.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ReservationTest {

    @Test
    public void testReservation() {
        // 전화번호 입력 처리 누락
        Reservation reservation = new Reservation("010-1234-5678");
        assertEquals("010-1234-5678", reservation.getPhone());
    }
}
