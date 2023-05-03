package com.example.omway.controller.omwUser;

import com.example.omway.dto.omwUser.OMWayUserDto;
import com.example.omway.model.omwUser.OMWayUser;
import com.example.omway.model.omwUser.Rider;
import com.example.omway.model.trip.Ride;
import com.example.omway.service.omwUser.IServiceRider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rider")
public class ControllerRider {

    @Autowired
    private IServiceRider service;


    @GetMapping("/all")
    public List<Rider> getAll(){
        return service.getAll();

    }

    @PostMapping(value="/save",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Rider saveRider(@RequestBody Rider rider){
        return service.save(rider);
    }

    @PutMapping( "/update")
    public Rider updateRider(@RequestBody Rider rider) throws Exception{
        if(rider.getCif()==null){
            throw new Exception("Please type the cif value");
        }
        return service.save(rider);
    }

    @DeleteMapping(value = "/delete/{cif}")
    public void deleteRider(@PathVariable String cif){
        service.deleteByString(cif);
    }
}


