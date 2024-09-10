package com.abcrestaurant.abcrestaurant.Entity;

import com.abcrestaurant.abcrestaurant.enums.ReservationStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int numberOfPersons;
    private int phoneNumber;
    private LocalDate reservationDate;
    private LocalTime reservationTime;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    // No need to manually define getters and setters when using @Data from Lombok
}
