package com.example.mungsang.service;

import com.example.mungsang.service.EmailService;
import com.example.mungsang.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
public class ReservationServiceTest {

    @Mock
    private EmailService emailService;

    @InjectMocks
    private ReservationService reservationService;

    public ReservationServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testReserve() {
        String phone = "01054760926";
        reservationService.reserve(phone);

        verify(emailService, times(1)).sendEmail(
                eq("baldmaax@gmail.com"),
                eq("새로운 설치 링크 요청"),
                eq("전화번호: " + phone) // phone 변수와 일치하는지 확인
        );
    }
}
