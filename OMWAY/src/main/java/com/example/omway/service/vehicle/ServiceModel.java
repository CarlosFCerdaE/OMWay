package com.example.omway.service.vehicle;

import com.example.omway.model.vehicle.Model;
import com.example.omway.repository.vehicle.IRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ServiceModel implements IServiceModel {
    @Autowired
    private IRepositoryModel repositoryModel;

    @Override
    public List<Model> getAll() {
        return repositoryModel.findAll();
    }

    @Override
    public Model save(@RequestBody Model model) {
        Model m = repositoryModel.findById(model.getId()).get();
        m.setId(model.getId());
        m.setName(model.getName());
        return repositoryModel.save(m);

    }

    @Override
    public void delete(Integer modelId) {
        repositoryModel.deleteById(modelId);
    }
}