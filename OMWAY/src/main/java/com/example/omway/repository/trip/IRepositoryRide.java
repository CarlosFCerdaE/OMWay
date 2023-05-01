package com.example.omway.repository.trip;

import com.example.omway.model.trip.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryRide extends JpaRepository<Ride,Integer> {
}
