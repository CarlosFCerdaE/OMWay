package com.example.omway.repository.trip;

import com.example.omway.model.omwUser.Rider;
import com.example.omway.model.trip.Ride;
import jakarta.persistence.EntityResult;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IRepositoryRide extends JpaRepository<Ride,Integer> {
    @Query(value = "SELECT * FROM [Trip].[Ride] r WHERE r.rider_cif = :cif AND r.state IN (0, 1, 2,3)", nativeQuery = true)
    List<Ride> findInProgressRidesByCif(@Param("cif") String cif);

    @Query(value = "SELECT * FROM [Trip].[Ride] r WHERE r.rider_cif = :cif AND r.state IN (4, 5, 6)", nativeQuery = true)
    List<Ride> findDiscontinuedRideByCif(@Param("cif") String cif);

    @Query(value = "SELECT * FROM [Trip].[Ride] WHERE state = '0'", nativeQuery = true)
    List<Ride> getRequestedRides();



}
