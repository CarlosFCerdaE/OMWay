package com.example.omway.service.trip;

import com.example.omway.dto.trip.RideDto;
import com.example.omway.model.trip.Ride;
import org.springframework.stereotype.Service;

@Service
public interface IServiceRide {
    public Ride save(RideDto rideDto);

}
