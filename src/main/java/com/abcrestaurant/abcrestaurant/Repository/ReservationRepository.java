package com.abcrestaurant.abcrestaurant.Repository;

import com.abcrestaurant.abcrestaurant.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByReservationDate(LocalDate reservationDate);
}
