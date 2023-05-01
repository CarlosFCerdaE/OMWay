package com.example.omway.model.payment;


import com.example.omway.OMWUser.Ride;
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
    private Integer id;
   //private double baseFare;
    //private double PerKmFare;
    private double total;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private boolean state;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "rideId", referencedColumnName = "id")
    private Ride ride;

}
