package com.abcrestaurant.abcrestaurant.Service;

;
import com.abcrestaurant.abcrestaurant.Entity.Booking;
import com.abcrestaurant.abcrestaurant.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }
}

