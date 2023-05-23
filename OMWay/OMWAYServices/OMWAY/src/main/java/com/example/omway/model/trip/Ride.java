package com.example.omway.model.trip;

import com.example.omway.model.omwUser.Driver;
import com.example.omway.model.omwUser.OMWayUser;
import com.example.omway.model.omwUser.Rider;
import com.example.omway.model.payment.Payment;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;

@Entity
@Data
@Table(name="Ride",schema = "Trip")
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name="Ride.all",query="select e from Ride e")
})

public class Ride {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    private Time pickUpTime;

    private Time dropOffTime;
    private String pickUpLocation;
    private String dropOffLocation;

    private Double distance;
    private LocalDate date;
    private String notes;

    @Enumerated()
    private RideState state;
    private Double fare;
    private int rating;
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey=@ForeignKey(name="FK_rider_ride_ridercif"))
    @JsonBackReference
    private Rider rider;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey=@ForeignKey(name="FK_driver_ride_drivercif"))
    @JsonBackReference
    private Driver driver;

    @OneToOne(mappedBy = "ride")
    @JsonBackReference
    private Payment payment;

}
