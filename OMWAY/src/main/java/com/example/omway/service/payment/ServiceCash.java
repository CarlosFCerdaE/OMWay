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
    private IRepositoryConfigFare config;


    @Autowired
    private IRepositoryCash iRepositoryCash;


    @Autowired
    private IRepositoryPayment iRepositoryPayment;

    @Autowired
    private IRepositoryRide repositoryRide;

    @Override
    public Cash save(CashDto cashDto) {
        Optional<Cash> c1 = iRepositoryCash.findById(cashDto.getPaymentId());
        Cash c = new Cash();
        if(c1.isPresent()){
            c = c1.get();
        }

        Optional<Ride> ride = repositoryRide.findById(cashDto.getRideId());
        Ride ride2 = new Ride();
        if(ride.isPresent()){
            ride2 = ride.get();
        }

        ConfigFare baseFare =config.findByName("Base Fare");
        ConfigFare kmFare = config.findByName("Per Km Fare");

        double totalRide = (baseFare.getFare() + (kmFare.getFare() * ride2.getDistance()));
        c.setTotal(totalRide);
        c.setRide(ride2);

        return iRepositoryCash.save(c);

    }

    @Override
    public List<Cash> getAllCashPayment() {

        List<Payment> paymentsList = iRepositoryPayment.findAll();
        List<Cash> cashList = new ArrayList<>();
        for (Payment payment : paymentsList) {
            if (payment instanceof Cash) {
                cashList.add((Cash) payment);
            }
        }
        return cashList;
    }

    @Override
    public Cash getCashById(Integer id) {
        Optional<Payment> Payment = iRepositoryPayment.findById(id);
        if (Payment.isPresent() && Payment.get() instanceof Cash) {
            return (Cash) Payment.get();
        } else {
            throw new ResourceNotFoundException("Payment was not found");
        }
    }
}

