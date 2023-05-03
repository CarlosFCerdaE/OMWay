package com.example.omway.service.omwUser;

import com.example.omway.dto.omwUser.OMWayUserDto;
import com.example.omway.model.omwUser.Driver;
import com.example.omway.model.payment.Payment;
import com.example.omway.model.trip.Ride;
import com.example.omway.model.vehicle.Car;
import com.example.omway.model.vehicle.Model;
import com.example.omway.repository.omwUser.IRepositoryDriver;
import com.example.omway.repository.vehicle.IRepositoryCar;
import com.example.omway.service.omwUser.IServiceDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ServiceDriver implements IServiceDriver {
    @Autowired
    private IRepositoryDriver repodriver;
    @Autowired
    private IRepositoryCar repocar;
    @Override
    public List<Driver> getAll() {
        return repodriver.findAll();
    }

    @Override
    public Driver save(Driver driver) {
        Driver d =new Driver();
        try{
            d =  repodriver.findById(driver.getCif()).get();
        }
        catch (NoSuchElementException e){
            System.out.println("Non existent cif");
        }
        //List<Car> driverCars=d.getDriverCars();
        //List<Car> datoscars=new ArrayList<>();
        //List<Ride> driverRides=driver.getDriverRides();
        //List<Ride> datosrides=new ArrayList<>();

        d.setCif(driver.getCif());
        d.setName(driver.getName());
        d.setPassword(driver.getPassword());
        d.setPhone(driver.getPhone());
        d.setEmail(driver.getEmail());
        d.setState(driver.isState());
        d.setDlIssueDate(driver.getDlIssueDate());
        d.setDlExpirationDate(driver.getDlExpirationDate());
        d.setNumberRides(driver.getNumberRides());
        d.setSumRating(driver.getSumRating());
    /*
        d.setDriverCars(driverCars);
        for(Car car:driverCars){
            Car c=new Car();
            //Model mo=new Model();
            c.setDriver(d);
            c.setLicensePlate(car.getLicensePlate());
            c.setColor(car.getColor());
            c.setYear(car.getYear());
            c.setState(car.isState());
            c.setModel(repocar.findById());
            datoscars.add(c);
        }
        d.setDriverCars(datoscars);
        /*
        d.setDriverRides(driver.getDriverRides());
        for(Ride ride:driverRides){

            Ride rd=new Ride();

            rd.setDriver(d);
            rd.setPickUpLocation(ride.getPickUpLocation());
            rd.setDropOffLocation(ride.getDropOffLocation());
            rd.setPickUpTime(ride.getPickUpTime());
            rd.setDropOffTime(ride.getDropOffTime());
            rd.setDistance(ride.getDistance());
            rd.setNotes(ride.getNotes());
            rd.setDate(ride.getDate());
            rd.setState(ride.getState());
            rd.setFare(ride.getFare());
            rd.setRating(ride.getRating());
            rd.setComment(ride.getComment());
            //rd.setPayment(null);
            datosrides.add(rd);
        }
        d.setDriverRides(datosrides);


*/
        return repodriver.save(d);
    }


    @Override
    public void deleteById(String cif) {
        repodriver.deleteById(cif);
    }
}
