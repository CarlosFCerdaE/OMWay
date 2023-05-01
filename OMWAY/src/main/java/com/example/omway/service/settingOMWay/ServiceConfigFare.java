package com.example.omway.service.settingOMWay;

import com.example.omway.model.settingsOMWay.ConfigFare;
import com.example.omway.repository.settingsOMWay.IRepositoryConfigFare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return repositoryConfigFare.save(configFare);
    }

    @Override
    public void deleteConfigFare(Integer id) {

        repositoryConfigFare.deleteById(id);

    }

}
