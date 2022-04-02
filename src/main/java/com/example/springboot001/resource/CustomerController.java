package com.example.springboot001.resource;

import com.example.springboot001.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    // http://localhost:8080/customer/
    @GetMapping("/")
    public String allCustomers() {
        return customerService.allCustomers();
    }

    // http://localhost:8080/customer/add?firstname=John&lastname=Doe
    @GetMapping("/add")
    public Long addCustomer(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) {
        return customerService.add(firstName, lastName);
    }

    // localhost:8080/customer/onlypaulsthenlastnametouppercase
    @GetMapping("/onlypaulsthenlastnametouppercase")
    public String onlyCustomersWithPaulAsFirstNameThenLastNameToUpperCase() {
        return customerService.onlyCustomersWithPaulAsFirstNameThenLastNameToUpperCase();
    }

}
