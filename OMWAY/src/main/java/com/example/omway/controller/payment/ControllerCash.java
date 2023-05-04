package com.example.omway.controller.payment;

import com.example.omway.dto.payment.CashDto;
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



    @GetMapping("/all")
    public List<Cash> getAll(){
        return serviceCash.getAllCashPayment();

    }

    @GetMapping("/{id}")
    public Cash getCashById(@PathVariable Integer id) {
        return serviceCash.getCashById(id);
    }

    @PostMapping("/save")
    public Payment save(@RequestBody CashDto cashDto){

        return serviceCash.save(cashDto);
    }

    @PutMapping("/update")
    public Payment update(@RequestBody CashDto cashDto)throws Exception{
        if(cashDto.getPaymentId()==null){
            throw new Exception("Please, send Id value");
        }
        return serviceCash.save(cashDto);
    }

}

