package com.example.omway.controller.trip;

import com.example.omway.dto.trip.RideDto;
import com.example.omway.model.trip.Ride;
import com.example.omway.service.trip.IServiceRide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ride")
public class ControllerRide {
    @Autowired
    private IServiceRide serviceRide;

    @PostMapping("/save")
    public Ride saveRide(@RequestBody RideDto rideDto){
        System.out.println(rideDto.getDate());
        return serviceRide.save(rideDto);
    }

    @PutMapping("/update")
    public Ride updateRide(@RequestBody RideDto rideDto) throws Exception {
        if(rideDto.getId()==null){
            throw new Exception("Please, send the Id value");
        }
        return serviceRide.save(rideDto);
    }

    @GetMapping("/InProgressRides")
    public List<Ride> findInProgressRidesByCif(@Param("cif")String cif){
        return serviceRide.findInProgressRidesByCif(cif);
    }

    @GetMapping("/DiscontinuedRides")
    public List<Ride> findDiscontinuedRideByCif(@Param("cif")String cif){
        return serviceRide.findDiscontinuedRideByCif(cif);
    }

    @GetMapping("/rideRequested")
    public List<Ride> getRequestedRides(){
        return serviceRide.getRequestedRides();
    }
}
