package com.example.omway.service.vehicle;

import com.example.omway.model.vehicle.Model;
import com.example.omway.repository.vehicle.IRepositoryMake;
import com.example.omway.repository.vehicle.IRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ServiceModel implements IServiceModel {
    @Autowired
    private IRepositoryModel repositoryModel;
    @Autowired
    private IRepositoryMake makeRepository;

    @Override
    public List<Model> getAll() {
        return repositoryModel.findAll();
    }

    @Override
    public Model save(@RequestBody Model model) {
        Model m = new Model();
        try{
             m = repositoryModel.findById(model.getId()).get();
        }
        catch (NoSuchElementException e){
            System.out.println("Non existent id");
        }

        m.setId(model.getId());
        m.setName(model.getName());
        m.setMake(
            makeRepository.findById(model.getMake().getId()).get()
        );
        return repositoryModel.save(m);

    }

    @Override
    public void delete(Integer modelId) {
        repositoryModel.deleteById(modelId);
    }
}