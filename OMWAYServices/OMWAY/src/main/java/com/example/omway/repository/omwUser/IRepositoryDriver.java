package com.example.omway.repository.omwUser;

import com.example.omway.model.omwUser.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryDriver extends JpaRepository<Driver,String> {
}
