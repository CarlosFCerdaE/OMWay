package com.example.omway.controller.vehicle;

import com.example.omway.service.vehicle.ServiceMake;
import com.example.omway.model.vehicle.Make;
import com.example.omway.service.vehicle.IMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/make")
public class MakeController {

    @Autowired private IMakeService makeService;

    @GetMapping("/all")
    public List<Make> getAll(){
        return makeService.getAll();

    }

    @PostMapping("/save")
    public Make saveMake(@RequestBody Make make){
        return makeService.save(make);
    }

    @PutMapping(value = "/update")
    public Make updateMake(@RequestBody Make make)
            throws Exception{
        if(make.getId()==null){
            throw new Exception("Please type the Id value");
        }
        return makeService.save(make);
    }

    @DeleteMapping(value = "/delete/{Id}")
    public void deleteMake(@PathVariable Integer Id){
        makeService.deleteById(Id);
    }
}

