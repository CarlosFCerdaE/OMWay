package com.example.omway.service.vehicle;

import com.example.omway.model.vehicle.Make;
import com.example.omway.repository.vehicle.IRepositoryMake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ServiceMake implements IServiceMake {

    @Autowired
    private IRepositoryMake IRepositoryMake;

    @Override
    public List<Make> getAll() {
        return IRepositoryMake.findAll();
    }

    @Override
    public Make save(Make make) {
        Make m = new Make();
        try{
            m = IRepositoryMake.findById(make.getId()).get();
        }
        catch (NoSuchElementException e){
            System.out.println("Non existent id");
        }
        m.setName(make.getName());
        return IRepositoryMake.save(m);


    }

    @Override
    public void deleteById(Integer id) {
        IRepositoryMake.deleteById(id);
    }
}
