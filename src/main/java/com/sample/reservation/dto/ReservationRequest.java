package com.sample.reservation.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record ReservationRequest(

        @NotNull(message = "Id는 필수값입니다.")
        Long userId,

        @NotNull(message = "좌석 Id는 필수값입니다.")
        Long seatId,

        @NotNull(message = "시작 시간은 필수값입니다.")
        LocalDateTime startTime,

        @NotNull(message = "종료 시간은 필수값입니다.")
        LocalDateTime endTime,

        @Positive(message = "결제 금액은 0원보다 커야합니다.")
        int amount
) {}