package com.example.omway.repository.vehicle;

import com.example.omway.model.vehicle.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IRepositoryModel extends JpaRepository<Model, Integer> {
}