package com.example.omway.repository.omwUser;

import com.example.omway.model.omwUser.OMWayUser;
import com.example.omway.model.omwUser.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryRider extends JpaRepository<Rider,String> {
}
