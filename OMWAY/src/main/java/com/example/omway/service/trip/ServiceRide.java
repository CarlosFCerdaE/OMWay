package com.example.omway.service.trip;

import com.example.omway.dto.trip.RideDto;
import com.example.omway.model.trip.Ride;
import com.example.omway.repository.trip.IRepositoryRide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceRide implements IServiceRide {

    @Autowired
    private IRepositoryRide repositoryRide;
    @Autowired
    private IRepositoryRider repositoryRider;
    @Autowired
    private IRepositoryDriver repositoryDriver;
    @Autowired
    private IRepositoryPayment repositoryPayment;

    @Override
    public Ride save(RideDto rideDto) {
        Ride r = repositoryRide.findById(rideDto.getId()).get();
        r.setPickUpTime(rideDto.getPickUpTime());
        r.setDropOffTime(rideDto.getDropOffTime());
        r.setPickUpLocation(rideDto.getPickUpLocation());
        r.setDropOffLocation(rideDto.getDropOffLocation());
        r.setDistance(rideDto.getDistance());
        r.setDate(rideDto.getDate());
        r.setNotes(rideDto.getNotes());
        r.setState(rideDto.getState());
        r.setFare(rideDto.getFare());
        r.setRating(rideDto.getRating());
        r.setComment(rideDto.getComment());
        r.setRider(
                repositoryRider.findById(rideDto.getRiderId()).get()
                );
        r.setDriver(
                repositoryDriver.findById(rideDto.getDriverId()).get()
        );
        r.setPayment(
                repositoryPayment.findById(rideDto.getPaymentId()).get()
        );

        return repositoryRide.save(r);
    }


}
