package com.abcrestaurant.abcrestaurant.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class AdminController {

    @PutMapping("/bookings/{id}/confirm")
    public void confirmBooking(@PathVariable Long id) {
        // Implement logic to confirm the booking
    }

    @DeleteMapping("/bookings/{id}/cancel")
    public void cancelBooking(@PathVariable Long id) {
        // Implement logic to cancel the booking
    }

    @DeleteMapping("/bookings/{id}")
    public void deleteBooking(@PathVariable Long id) {
        // Implement logic to delete the booking
    }

    @DeleteMapping("/queries/{id}")
    public void deleteQuery(@PathVariable Long id) {
        // Implement logic to delete the query
    }

}
