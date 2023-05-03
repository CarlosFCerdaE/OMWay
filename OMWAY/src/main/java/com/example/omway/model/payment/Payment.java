package com.example.omway.model.payment;


import com.example.omway.model.trip.Ride;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name="Payment",schema = "Payment")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer paymentId;
    private double total;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @OneToOne( optional = false)
    @JoinColumn(name = "rideId", referencedColumnName = "id")
    @JsonManagedReference
    private Ride ride;

}
