package com.example.mungsang.controller;

import com.example.mungsang.model.Reservation;
import com.example.mungsang.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/api/reservation")
    public ResponseEntity<String> reserve(@RequestBody Reservation reservation) {
        String phone = reservation.getPhone();

        // 전화번호 유효 체크
        if (!isValidPhoneNumber(phone)) {
            return ResponseEntity.badRequest().body("휴대폰 번호는 숫자만 입력해주세요.");
        }

        reservationService.reserve(phone);
        return ResponseEntity.ok("링크 전송 완료");
    }

    // 전화번호가 숫자와 "-" 만 포함하고 올바른 형식인지 체크
    private boolean isValidPhoneNumber(String phone) {
        return phone.matches("^\\d{2,3}-\\d{3,4}-\\d{4}$");
    }
}
