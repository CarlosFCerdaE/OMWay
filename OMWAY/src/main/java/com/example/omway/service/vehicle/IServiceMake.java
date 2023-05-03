package com.example.omway.service.vehicle;

import com.example.omway.model.vehicle.Make;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceMake {

    public List<Make> getAll();

    public Make save(Make make);

    public void deleteById(Integer id);

}
