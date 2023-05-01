package com.example.omway.dto;

import com.example.omway.model.trip.Ride;
import com.example.omway.model.vehicle.Car;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OMWayUserDto {
    private String driverCif;
    private String riderCif;

    private String password;
    private String name;
    private String phone;
    private String email;
    private boolean state;
    private List<Ride> riderRides;

    //Driver
    private LocalDate dlIssueDate;
    private LocalDate dlExpirationDate;
    private int sumRating;

    private int numberRides;
    private List<Car> driverCars;

    private List<Ride> driverRides;
}
