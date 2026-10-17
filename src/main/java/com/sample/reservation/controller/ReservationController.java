package com.sample.reservation.controller;

import com.sample.reservation.dto.ReservationRequest;
import com.sample.reservation.dto.ReservationResponse;
import com.sample.reservation.service.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationResponse> createReservation(@Valid @RequestBody ReservationRequest request) {

        ReservationResponse response = reservationService.reserveSeat(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
