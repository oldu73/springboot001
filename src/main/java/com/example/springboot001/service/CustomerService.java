package com.example.springboot001.service;

import com.example.springboot001.entity.Customer;
import com.example.springboot001.repository.CustomerRepository;
import com.example.springboot001.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    Converter converter;

    public String allCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return String.join(", ", customers.toString());
    }

    public Long add(String firstName, String lastName) {
        Customer customer = new Customer(firstName, lastName);
        customerRepository.save(customer);
        return customer.getId();
    }

    public String onlyCustomersWithPaulAsFirstNameThenLastNameToUpperCase() {
        List<Customer> customers = customerRepository.findAll();

        List<Customer> onlyPauls = customers.stream().filter(customer -> "Paul".equals(customer.getFirstName())).collect(Collectors.toList());

        converter.lastNameToUpperCase(onlyPauls);

        return !onlyPauls.isEmpty() ? String.join(", ", onlyPauls.toString()) : "none";
    }

}
