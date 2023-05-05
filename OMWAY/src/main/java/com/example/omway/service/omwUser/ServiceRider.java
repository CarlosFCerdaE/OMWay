package com.example.omway.service.omwUser;

import com.example.omway.dto.omwUser.RiderDto;
import com.example.omway.model.omwUser.Rider;
import com.example.omway.model.trip.Ride;
import com.example.omway.repository.omwUser.IRepositoryDriver;
import com.example.omway.repository.omwUser.IRepositoryRider;
import com.example.omway.service.omwUser.IServiceRider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ServiceRider implements IServiceRider {


    @Autowired
    private IRepositoryRider reporider;
    @Autowired
    private IRepositoryDriver repodriver;
    @Override
    public List<Rider> getAll() {
        return reporider.findAll();
    }

    @Override
    public Rider save(RiderDto riderDto) {

        Optional <Rider> r1 = reporider.findById(riderDto.getRiderCif());
        Rider r = new Rider();
        if(r1.isPresent()) {
            r = r1.get();
        }
        r.setCif(riderDto.getRiderCif());
        r.setName(riderDto.getName());
        r.setPassword(riderDto.getPassword());
        r.setPhone(riderDto.getPhone());
        r.setEmail(riderDto.getEmail());
        r.setState(riderDto.isState());

        return reporider.save(r);
    }



    @Override
    public void deleteByString(String cif) {
        reporider.deleteById(cif);
    }
}
