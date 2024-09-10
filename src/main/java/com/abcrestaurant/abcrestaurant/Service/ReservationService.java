package com.abcrestaurant.abcrestaurant.Service;

import com.abcrestaurant.abcrestaurant.Entity.Reservation;


import com.abcrestaurant.abcrestaurant.Entity.Reservation;


import java.time.LocalDate;
import java.util.List;

public interface ReservationService {
    Reservation createReservation(Reservation reservation);

    List<Reservation> getAllReservations();
    void deleteReservation(Long id);
    Reservation updateReservation(Long id, Reservation reservation);

    boolean checkAvailability(LocalDate reservationDate);

    void confirmReservation(Long id);

    void cancelReservation(Long id);
}
