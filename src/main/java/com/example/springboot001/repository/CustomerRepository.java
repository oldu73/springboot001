package com.example.springboot001.repository;

import com.example.springboot001.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findAll();

    List<Customer> findByFirstName(String firstName);

    List<Customer> findByLastName(String lastName);

    Customer findById(long id);

}
