package com.example.omway.dto.payment;

import com.example.omway.model.payment.PaymentMethod;
import lombok.Data;

@Data
public class CashDto {
    private Integer paymentId;
    private double total;
    private PaymentMethod paymentMethod;
    private Integer rideId;
}
