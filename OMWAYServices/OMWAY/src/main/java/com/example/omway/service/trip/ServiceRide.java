package com.example.omway.service.trip;

import com.example.omway.dto.trip.RideDto;
import com.example.omway.model.omwUser.Driver;
import com.example.omway.model.payment.Cash;
import com.example.omway.model.payment.Payment;
import com.example.omway.model.trip.Ride;
import com.example.omway.repository.omwUser.IRepositoryDriver;
import com.example.omway.repository.omwUser.IRepositoryRider;
import com.example.omway.repository.trip.IRepositoryRide;
import com.example.omway.repository.vehicle.IRepositoryCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ServiceRide implements IServiceRide {

    @Autowired
    private IRepositoryRide repositoryRide;
    @Autowired
    private IRepositoryRider repositoryRider;
    @Autowired
    private IRepositoryDriver repositoryDriver;
    @Autowired
    private IRepositoryCar repositoryCar;

    @Override
    public Ride save(RideDto rideDto) {

        Optional<Ride> r1 = repositoryRide.findById(rideDto.getId());

        Ride r = new Ride();

        if (r1.isPresent()){
            r = r1.get();
            System.out.println("Esta presente, procedemos a actualizar");
        }
        System.out.println(rideDto.getDate());

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


        if(rideDto.getDriverId()!=null){
            r.setDriver(
                    repositoryDriver.findById(rideDto.getDriverId()).get()
            );
        }
        if(rideDto.getCarId()!=null){
            r.setCar(
                    repositoryCar.findById(rideDto.getCarId()).get()
            );
        }

        return repositoryRide.save(r);
    }
/*
    @Override
    public List<Ride> findInProgressRidesByCif(String cif) {
        return repositoryRide.findInProgressRidesByCif(cif);
    }

    @Override
    public List<Ride> findDiscontinuedRideByCif(String cif) {
        List<Ride> ridesCash = repositoryRide.findDiscontinuedRideByCif(cif);
        for (Ride ride : ridesCash) {
            Payment payment = ride.getPayment();
            if (payment instanceof Cash) {
                Cash cashPayment = (Cash) payment;
                ride.setPayment(cashPayment);
            }
        }
        return ridesCash;
    }

    @Override
    public List<Ride> getRequestedRides() {
        return repositoryRide.getRequestedRides();
    }
*/

}
