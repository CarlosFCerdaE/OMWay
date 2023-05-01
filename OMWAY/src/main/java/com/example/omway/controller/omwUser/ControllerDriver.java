package com.example.omway.controller;

import com.example.omway.dto.OMWayUserDto;
import com.example.omway.model.omwUser.Driver;
import com.example.omway.model.omwUser.OMWayUser;
import com.example.omway.service.omwUser.IServiceDriver;
import com.example.omway.service.omwUser.ServiceDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class ControllerDriver {
    @Autowired
    private IServiceDriver serviceDriver;
    @GetMapping("/all")
    public List<Driver> getAll(){
        return serviceDriver.getAll();

    }

    @PostMapping("/save")
    public Driver saveDriver(@RequestBody Driver driver){
        return serviceDriver.save(driver);
    }

    @PutMapping(value = "/update")
    public Driver updateDriver(@RequestBody Driver driver) throws Exception{
        if(driver.getCif()==null){
            throw new Exception("Please type the cif value");
        }
        return serviceDriver.save(driver);
    }

    @DeleteMapping(value = "/delete/{cif}")
    public void deleteDriver(@PathVariable String cif){
        serviceDriver.deleteById(cif);
    }
}
