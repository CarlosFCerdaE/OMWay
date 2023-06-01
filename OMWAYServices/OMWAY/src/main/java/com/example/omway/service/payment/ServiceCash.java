package com.example.omway.service.payment;

import com.example.omway.dto.payment.CashDto;
import com.example.omway.model.payment.Cash;
import com.example.omway.model.payment.Payment;
import com.example.omway.model.settingsOMWay.ConfigFare;
import com.example.omway.model.trip.Ride;
import com.example.omway.repository.payment.IRepositoryPayment;
import com.example.omway.repository.settingsOMWay.IRepositoryConfigFare;
import com.example.omway.repository.payment.IRepositoryCash;
import com.example.omway.repository.trip.IRepositoryRide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class ServiceCash implements IServiceCash {

    @Autowired
    private IRepositoryCash repositoryCash;
    @Autowired
    private IRepositoryPayment repositoryPayment;

    @Autowired
    private IRepositoryRide repositoryRide;

   @Override
    public Cash getCashById(Integer id) {
        Optional<Payment> p1 = repositoryPayment.findById(id);
        if (p1.isPresent() && p1.get() instanceof Cash) {
            return (Cash) p1.get();
        } else {
            throw new ResourceNotFoundException("Payment was not found");
        }
    }

    @Override
    public Cash save(CashDto cashDto) {
        Optional<Cash> c1 = repositoryCash.findById(cashDto.getPaymentId());
        Cash c = new Cash();
        if(c1.isPresent()){
            c = c1.get();
        }

        Ride r = repositoryRide.findById(cashDto.getRideId()).get();
        c.setRide(r);
        return repositoryCash.save(c);

    }
}

