package com.example.omway.service.payment;

import com.example.omway.model.payment.Cash;
import org.springframework.stereotype.Service;

@Service
public interface IServiceCash {

    public Cash save(Cash cash);


}
