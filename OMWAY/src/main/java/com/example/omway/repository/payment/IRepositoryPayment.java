package com.example.omway.repository.payment;

import com.example.omway.model.payment.Cash;
import com.example.omway.model.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IRepositoryPayment extends CrudRepository<Payment,Integer> {

}
