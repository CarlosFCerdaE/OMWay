package com.example.omway.service.omwUser;

import com.example.omway.model.omwUser.Rider;
import com.example.omway.model.trip.Ride;
import com.example.omway.repository.omwUser.IRepositoryDriver;
import com.example.omway.repository.omwUser.IRepositoryRider;
import com.example.omway.service.omwUser.IServiceRider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
    public Rider save(Rider rider) {
        //List<Ride> userRides = omwuserDto.getRiderRides();
        //List<Ride> datos=new ArrayList<>();
        Rider o = new Rider();
        try{
            o =  reporider.findById(rider.getCif()).get();
        }
        catch (NoSuchElementException e){
            System.out.println("Non existent id");
        }
        o.setCif(rider.getCif());
        o.setName(rider.getName());
        o.setPassword(rider.getPassword());
        o.setPhone(rider.getPhone());
        o.setEmail(rider.getEmail());
        o.setState(rider.isState());
        //o.setRiderRides();
        /*
        for(Ride rides:userRides){

            Ride r=new Ride();


            r.setRider(o);
            r.setPickUpLocation(rides.getPickUpLocation());
            r.setDropOffLocation(rides.getDropOffLocation());
            r.setPickUpTime(rides.getPickUpTime());
            r.setDropOffTime(rides.getDropOffTime());
            r.setDistance(rides.getDistance());
            r.setNotes(rides.getNotes());
            r.setDate(rides.getDate());
            r.setState(rides.getState());
            r.setFare(rides.getFare());
            r.setRating(rides.getRating());
            r.setComment(rides.getComment());
            r.setDriver(repodriver.findById(omwuserDto.getDriverCif()).get());
            r.setPayment(null);
            datos.add(r);
        }
        o.setRiderRides(datos);
*/


        return reporider.save(o);
    }



    @Override
    public void deleteByString(String cif) {
        reporider.deleteById(cif);
    }
}
