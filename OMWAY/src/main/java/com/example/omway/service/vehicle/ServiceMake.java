package com.example.omway.service.vehicle;

import com.example.omway.model.vehicle.Make;
import com.example.omway.repository.vehicle.MakeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceMake implements IMakeService{

    @Autowired
    private MakeRepository makeRepository;

    @Override
    public List<Make> getAll() {
        return makeRepository.findAll();
    }

    @Override
    public Make save(Make make) {
        Make m = makeRepository.findById(make.getId()).get();
        m.setName(make.getName());

        return makeRepository.save(m);
    }

    @Override
    public void deleteById(Integer id) {
        makeRepository.deleteById(id);
    }
}
