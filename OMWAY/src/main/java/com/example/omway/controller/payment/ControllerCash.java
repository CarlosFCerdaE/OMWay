package com.example.omway.controller.payment;

import com.example.omway.model.payment.Cash;
import com.example.omway.model.payment.Payment;
import com.example.omway.service.payment.IServiceCash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cash")
public class ControllerCash {

    @Autowired
    private IServiceCash serviceCash;

    @PostMapping("/save")
    public Payment save(@RequestBody Cash cash){

        return serviceCash.save(cash);
    }

    @GetMapping("/all")
    public List<Cash> getAll(){
        return serviceCash.getAllCashPayment();

    }

    @GetMapping("/{id}")
    public Cash getCashById(@PathVariable Integer id) {
        return serviceCash.getCashById(id);
    }
}

