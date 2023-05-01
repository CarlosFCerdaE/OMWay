package com.example.omway.service.payment;

import com.example.omway.model.payment.Cash;
import com.example.omway.model.payment.Payment;

public interface IServicePayment {
    public Payment save(Payment payment);
}
