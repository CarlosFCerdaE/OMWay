package com.example.omway.controller.trip;

import com.example.omway.dto.trip.RideDto;
import com.example.omway.model.trip.Ride;
import com.example.omway.service.trip.IServiceRide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ride")
public class ControllerRide {
    @Autowired
    private IServiceRide serviceRide;

    @PostMapping("/save")
    public Ride saveRide(@RequestBody RideDto rideDto){return serviceRide.save(rideDto);}

    @PutMapping("/update")
    public Ride updateRide(@RequestBody RideDto rideDto) throws Exception {
        if(rideDto.getId()==null){
            throw new Exception("Please, send the Id value");
        }
        return serviceRide.save(rideDto);
    }
}
