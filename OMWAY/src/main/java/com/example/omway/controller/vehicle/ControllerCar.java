package com.example.omway.controller.vehicle;

import com.example.omway.model.vehicle.Car;
import com.example.omway.service.vehicle.IServiceCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class ControllerCar {
    @Autowired
    private IServiceCar serviceCar;

    @PostMapping("/save")
    public Car save(@RequestBody Car car){
        return serviceCar.save(car);
    }

    @PutMapping("/update")
    public Car update(@RequestBody Car car) throws Exception {
        if(car.getLicensePlate()==null){
            throw new Exception("Please, send the Id value");
        }
        return serviceCar.save(car);
    }

    @DeleteMapping(value="/delete/{id}")
    public void delete(@PathVariable String id) {
        serviceCar.delete(id);
    }
}
