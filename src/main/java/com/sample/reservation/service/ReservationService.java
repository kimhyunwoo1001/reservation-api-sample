package com.sample.reservation.service;

import com.sample.reservation.dto.ReservationRequest;
import com.sample.reservation.dto.ReservationResponse;
import com.sample.reservation.mapper.ReservationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationMapper reservationMapper;

    @Transactional
    public ReservationResponse reserveSeat(ReservationRequest request) {

        if (request.endTime().isBefore(request.startTime())) {
            throw new IllegalArgumentException("시작 시간과 종료 시간을 확인해주세요.");
        }

        int overCount = reservationMapper.countOverReservations(request.seatId(), request.startTime(), request.endTime());
        if (0 < overCount) throw new IllegalStateException("해당 시간에 이미 예약된 좌석입니다.");

        String status = "CONFIRMED";
        reservationMapper.insertReservation(request, status);

        return new ReservationResponse(
                request.userId(),
                request.seatId(),
                status,
                request.amount()
        );
    }
}
