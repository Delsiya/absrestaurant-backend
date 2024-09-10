package com.abcrestaurant.abcrestaurant.ServiceImpl;

import com.abcrestaurant.abcrestaurant.Entity.Reservation;
import com.abcrestaurant.abcrestaurant.Repository.ReservationRepository;
import com.abcrestaurant.abcrestaurant.Service.ReservationService;
import com.abcrestaurant.abcrestaurant.enums.ReservationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;



    @Override
    public Reservation createReservation(Reservation reservation) {
        reservation.setStatus(ReservationStatus.PENDING);
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation updateReservation(Long id, Reservation updatedReservation) {
        return reservationRepository.findById(id)
                .map(reservation -> {
                    reservation.setName(updatedReservation.getName());
                    reservation.setNumberOfPersons(updatedReservation.getNumberOfPersons());
                    reservation.setPhoneNumber(updatedReservation.getPhoneNumber());
                    reservation.setReservationDate(updatedReservation.getReservationDate());
                    reservation.setReservationTime(updatedReservation.getReservationTime());
                    return reservationRepository.save(reservation);
                }).orElseThrow(() -> new RuntimeException("Reservation not found"));
    }



    @Override
    public boolean checkAvailability(LocalDate reservationDate) {
        List<Reservation> reservations = reservationRepository.findByReservationDate(reservationDate);
        // Here, you can define the logic for checking availability, such as checking the number of reservations.
        return reservations.size() < 10; // Example logic: limit to 10 reservations per day
    }

    @Override
    public void confirmReservation(Long id) {

    }

    @Override
    public void cancelReservation(Long id) {

    }
}
