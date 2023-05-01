package com.example.omway.service.payment;

import com.example.omway.model.payment.Cash;
import com.example.omway.model.settingsOMWay.ConfigFare;
import com.example.omway.repository.settingsOMWay.IRepositoryConfigFare;
import com.example.omway.repository.payment.IRepositoryCash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCash implements IServiceCash {

    @Autowired
   private IRepositoryConfigFare config;

    @Autowired
   private IRepositoryCash iRepositoryCash;


    @Override
    public Cash save(Cash cash){

        ConfigFare baseFare = new ConfigFare();
        baseFare = config.findByName("Base Fare");
        double totalBaseFare = baseFare.getFare();
        ConfigFare kmFare = new ConfigFare();
        kmFare = config.findByName("Per Km Fare");
        double totalKmFare = kmFare.getFare();
        double totalRide = (totalBaseFare + (totalKmFare* cash.getRide().getDistance()));

        //payment.setBaseFare(totalBaseFare);
        //payment.setPerKmFare(totalKmFare);

        cash.setTotal(totalRide);
        return iRepositoryCash.save(cash);

    }


}
