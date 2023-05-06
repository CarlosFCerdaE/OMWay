package com.example.omway.service.omwUser;

import com.example.omway.dto.omwUser.DriverDto;
import com.example.omway.model.omwUser.Driver;
import com.example.omway.model.trip.Ride;
import com.example.omway.repository.omwUser.IRepositoryDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceDriver implements IServiceDriver {
    @Autowired
    private IRepositoryDriver repodriver;
    @Override
    public List<Driver> getAll() {
        return repodriver.findAll();
    }

    @Override
    public Driver save(DriverDto driverDto) {
        Optional<Driver> d1 = repodriver.findById(driverDto.getDriverCif());
        Driver d = new Driver();
        if (d1.isPresent()){
            d = d1.get();
        }

        d.setCif(driverDto.getDriverCif());
        d.setName(driverDto.getName());
        d.setPassword(driverDto.getPassword());
        d.setPhone(driverDto.getPhone());
        d.setEmail(driverDto.getEmail());
        d.setState(driverDto.isState());
        d.setDlIssueDate(driverDto.getDlIssueDate());
        d.setDlExpirationDate(driverDto.getDlExpirationDate());

        List<Ride> driverRides = d.getDriverRides();
        int numberOfRides = 0;
        int sum = 0;
        if(driverRides != null){
            numberOfRides = driverRides.size();
            for (Ride ride: driverRides){
                sum+= ride.getRating();
            }
        }
        d.setNumberRides(numberOfRides);
        d.setSumRating(sum);

        return repodriver.save(d);
    }


    @Override
    public void deleteById(String cif) {
        repodriver.deleteById(cif);
    }
}
