package com.example.mungsang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private EmailService emailService;

    private static final String RECIPIENT_EMAIL = "baldmaax@gmail.com";

    public void reserve(String phone){
        String subject = "새로운 설치 링크 요청";
        String text = "전화번호: " + phone;

        emailService.sendEmail(RECIPIENT_EMAIL, subject, text);
    }
}
