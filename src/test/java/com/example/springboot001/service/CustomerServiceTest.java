package com.example.springboot001.service;

import com.example.springboot001.entity.Customer;
import com.example.springboot001.repository.CustomerRepository;
import com.example.springboot001.util.Converter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    Converter converter;

    private static final String PAUL = "Paul";

    private static final List<Customer> CUSTOMERS = Arrays.asList(
            new Customer("John1", "Doe1"),
            new Customer("John2", "Doe2"),
            new Customer("Paul", "Paul1"),
            new Customer("John3", "Doe3"),
            new Customer("Paul", "Paul2"),
            new Customer("Paul", "Paul3"),
            new Customer("John4", "Doe4"),
            new Customer("Paul", "Paul4"),
            new Customer("John5", "Doe5"));

    @Test
    public void onlyCustomersWithPaulAsFirstNameThenLastNameToUpperCaseTest_WhenNoIn_ThenReturnNone() {
        String out = customerService.onlyCustomersWithPaulAsFirstNameThenLastNameToUpperCase();
        assertEquals("none", out);
    }

    @Test
    public void onlyCustomersWithPaulAsFirstNameThenLastNameToUpperCaseTest_WhenNotOnlyPaulsIn_ThenOnlyPaulsOut() {
        when(customerRepository.findAll()).thenReturn(CUSTOMERS);

        customerService.onlyCustomersWithPaulAsFirstNameThenLastNameToUpperCase();

        @SuppressWarnings("unchecked")
        ArgumentCaptor<List<Customer>> customersCaptor = ArgumentCaptor.forClass(List.class);

        verify(converter, times(1)).lastNameToUpperCase(customersCaptor.capture()); // For not captured/tested argument(s) replace with "any()"

        List<Customer> paulsOut = customersCaptor.getValue();

        assertEquals(4, paulsOut.size());
        assertTrue(paulsOut.stream().allMatch(customer -> PAUL.equals(customer.getFirstName())));
    }

}
