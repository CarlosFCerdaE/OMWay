package com.example.omway.controller.payment;

import com.example.omway.model.payment.Cash;
import com.example.omway.model.payment.Payment;
import com.example.omway.service.payment.IServiceCash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Cash")
public class ControllerCash {

    @Autowired
    private IServiceCash serviceCash;
    @PostMapping("/save")
    public Payment save(@RequestBody Cash cash){
        return serviceCash.save(cash);
    }
}
