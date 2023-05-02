package com.example.omway.service.vehicle;


import com.example.omway.model.vehicle.Car;
import com.example.omway.model.vehicle.Model;
import com.example.omway.repository.vehicle.IRepositoryCar;
import com.example.omway.repository.vehicle.IRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
@Component("ServiceCar")
public class ServiceCar implements IServiceCar {
    @Autowired
    private IRepositoryCar repositoryCar;
    private IRepositoryModel repositoryModel;
    @Override
    public Car save(@RequestBody Car car) {

        /*Car c = new Car();
        c.setLicensePlate(car.getLicensePlate());
        c.setYear(car.getYear());
        c.setColor(car.getColor());
        c.setState(car.isState());*/
        Car c =  repositoryCar.findById(car.getLicensePlate()).get();
        Model model = repositoryModel.findById(car.getModel().getId()).get();
        c.setLicensePlate(car.getLicensePlate());
        c.setYear(car.getYear());
        c.setColor(car.getColor());
        c.setState(car.isState());
        c.setModel(model);
        return repositoryCar.save(c);


    }

    @Override
    public void delete(String id) {
        repositoryCar.deleteById(id);
    }
}
