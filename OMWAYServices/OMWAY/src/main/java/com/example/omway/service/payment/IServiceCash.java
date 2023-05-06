package com.example.omway.service.payment;

import com.example.omway.dto.payment.CashDto;
import com.example.omway.model.payment.Cash;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceCash {

    public Cash save(CashDto cashDto);
    public List<Cash> getAllCashPayment();
    public Cash getCashById(Integer id);


}