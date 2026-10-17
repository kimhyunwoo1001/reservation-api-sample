package com.sample.reservation.mapper;

import com.sample.reservation.dto.ReservationRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

@Mapper
public interface ReservationMapper {

    int countOverReservations(
            @Param("seatId") Long seatId,
            @Param("startTime") LocalDateTime startTime,
            @Param("endTime") LocalDateTime endTime);

    void insertReservation(@Param("req") ReservationRequest request, @Param("status") String status);
}
