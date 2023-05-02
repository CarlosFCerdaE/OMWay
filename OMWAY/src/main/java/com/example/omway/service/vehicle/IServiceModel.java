package com.example.omway.service.vehicle;
import com.example.omway.model.vehicle.Model;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceModel {

    public List<Model> getAll();
    public Model save(Model model);

    public void delete(Integer modelId);

}