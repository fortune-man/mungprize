package com.example.mungsang.controller;

import com.example.mungsang.service.EmailService;
import com.example.mungsang.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReservationController.class)
public class ReservationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReservationService reservationService;

    @MockBean
    private EmailService emailService;

    @Test
    public void testReserve_Success() throws Exception {
        mockMvc.perform(post("/api/reservation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"phone\":\"010-5476-0926\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("링크 전송 완료"));

        verify(reservationService, times(1)).reserve("010-5476-0926");
    }

    @Test
    public void testReserve_InvalidPhoneNumber() throws Exception {
        mockMvc.perform(post("/api/reservation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"phone\":\"0105476-0926\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("휴대폰 번호는 숫자만 입력해주세요."));

        verify(reservationService, times(0)).reserve(any());
    }
}
