package com.example.omway.controller.vehicle;

import com.example.omway.model.vehicle.Make;
import com.example.omway.model.vehicle.Model;
import com.example.omway.service.vehicle.IServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/model")
public class ControllerModel {
    @Autowired
    private IServiceModel serviceModel;
    @GetMapping("/all")
    public List<Model> getAll() {
        return serviceModel.getAll();
    }


    @PostMapping("/save")
    public Model save(@RequestBody Model model){
        return serviceModel.save(model);
    }

    @PutMapping(value = "/update")
    public Model updateModel(@RequestBody Model model) throws Exception{
        if(model.getId()==null){
            throw new Exception("Please type the Id value");
        }
        return serviceModel.save(model);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer modelId){
            serviceModel.delete(modelId);
    }

}