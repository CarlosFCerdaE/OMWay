package com.example.omway.service.omwUser;

import com.example.omway.model.omwUser.OMWayUser;
import com.example.omway.model.omwUser.Rider;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IServiceRider {
    public List<Rider> getAll();

    public Rider save(Rider rider);

    public void deleteByString(String cif);
}
