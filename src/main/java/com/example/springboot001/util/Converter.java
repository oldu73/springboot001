package com.example.springboot001.util;

import com.example.springboot001.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class Converter {

    public void lastNameToUpperCase(List<Customer> customers) {
        customers.forEach(customer -> customer.setLastName(customer.getLastName().toUpperCase(Locale.ROOT)));
    }

}
