package com.example.omway.service.payment;

import com.example.omway.model.payment.Payment;
import com.example.omway.model.settingsOMWay.ConfigFare;
import com.example.omway.repository.payment.IRepositoryCash;
import com.example.omway.repository.settingsOMWay.IRepositoryConfigFare;
import com.example.omway.repository.payment.IRepositoryPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePayment implements IServicePayment {
    @Autowired
    private IRepositoryConfigFare config;

    @Autowired
    private IRepositoryPayment iRepositoryPayment;

    @Autowired
    private IRepositoryCash iRepositoryCash;
    

    // private ConfigFare fare;

    @Override
    public Payment save(Payment payment){

        //  List configFares = new ArrayList<ConfigFare>();
        // List<ConfigFare>configFares = config.findAllByStatus(true);
        /*
        for(ConfigFare option: configFares){
            option.getFare()
        }
        */
        ConfigFare baseFare = new ConfigFare();
        baseFare = config.findByName("Base Fare");
        double totalBaseFare = baseFare.getFare();
        ConfigFare kmFare = new ConfigFare();
        kmFare = config.findByName("Per Km Fare");
        double totalKmFare = kmFare.getFare();
        double totalRide = (totalBaseFare + (totalKmFare* payment.getRide().getDistance()));
        //  payment.setBaseFare(totalBaseFare);
        //  payment.setPerKmFare(totalKmFare);
        payment.setTotal(totalRide);
        return iRepositoryPayment.save(payment);

    }
}
