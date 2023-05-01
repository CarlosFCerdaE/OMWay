package com.example.omway.service.omwUser;

import com.example.omway.dto.OMWayUserDto;
import com.example.omway.model.omwUser.Driver;
import com.example.omway.model.omwUser.OMWayUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IServiceDriver {
    public List<Driver> getAll();

    public Driver save(Driver driver);


    public void deleteById(String cif);
}
