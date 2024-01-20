package com.example.securityappkinansaad.repositories;

import com.example.securityappkinansaad.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Eren
 **/
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findCustomerByEmail(String username);
}
