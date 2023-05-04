package com.example.omway.controller.omwUser;


import com.example.omway.dto.omwUser.DriverDto;
import com.example.omway.model.omwUser.Driver;
import com.example.omway.service.omwUser.IServiceDriver;
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
    public Driver saveDriver(@RequestBody DriverDto driverDto){
        return serviceDriver.save(driverDto);
    }

    @PutMapping(value = "/update")
    public Driver updateDriver(@RequestBody DriverDto driverDto) throws Exception{
        if(driverDto.getDriverCif()==null){
            throw new Exception("Please type the cif value");
        }
        return serviceDriver.save(driverDto);
    }

    @DeleteMapping(value = "/delete/{cif}")
    public void deleteDriver(@PathVariable String cif){
        serviceDriver.deleteById(cif);
    }
}
