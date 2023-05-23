package com.example.omway.repository.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface IRepositoryPayment <T, ID extends Serializable> extends JpaRepository<T, ID> {

}
