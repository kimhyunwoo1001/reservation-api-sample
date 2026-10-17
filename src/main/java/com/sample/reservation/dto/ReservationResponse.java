package com.sample.reservation.dto;

public record ReservationResponse(

        Long userId,
        Long seatId,
        String status,
        int amount
) {}