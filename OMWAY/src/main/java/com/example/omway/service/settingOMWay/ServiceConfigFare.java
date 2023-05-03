package com.example.omway.service.settingOMWay;

import com.example.omway.model.omwUser.Driver;
import com.example.omway.model.settingsOMWay.ConfigFare;
import com.example.omway.repository.settingsOMWay.IRepositoryConfigFare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ServiceConfigFare implements IServiceConfigFare {

    @Autowired
    private IRepositoryConfigFare repositoryConfigFare;

    @Override
    public List<ConfigFare> getConfigFare() {

        return repositoryConfigFare.findAll();
    }

    @Override
    public ConfigFare save(ConfigFare configFare) {
        ConfigFare configFare1 =new ConfigFare();
        try{
            configFare1 =  repositoryConfigFare.findById(configFare1.getId()).get();
        }
        catch (NoSuchElementException e){
            System.out.println("Non existent id");
        }
        configFare1.setName(configFare.getName());
        configFare1.setFare(configFare.getFare());
        configFare1.setState(configFare.isState());
        return repositoryConfigFare.save(configFare);

    }

    @Override
    public void deleteConfigFare(Integer id) {

        repositoryConfigFare.deleteById(id);

    }

}
