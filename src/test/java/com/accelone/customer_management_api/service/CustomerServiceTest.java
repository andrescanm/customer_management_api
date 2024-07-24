package com.accelone.customer_management_api.service;

import com.accelone.customer_management_api.model.Customer;
import com.accelone.customer_management_api.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        // Arrange
        Customer customer1 = new Customer(1L, "John Doe", "john.doe@example.com");
        Customer customer2 = new Customer(2L, "Jane Smith", "jane.smith@example.com");
        when(customerRepository.findAll()).thenReturn(Arrays.asList(customer1, customer2));

        // Act
        List<Customer> customers = customerService.findAll();

        // Assert
        assertEquals(2, customers.size());
        verify(customerRepository, times(1)).findAll();
    }

    @Test
    void testFindByName() {
        // Arrange
        String name = "John Doe";
        Customer customer = new Customer(1L, name, "john.doe@example.com");
        when(customerRepository.findByName(name)).thenReturn(Optional.of(customer));

        // Act
        Optional<Customer> foundCustomer = customerService.findByName(name);

        // Assert
        assertTrue(foundCustomer.isPresent());
        assertEquals(name, foundCustomer.get().getName());
        verify(customerRepository, times(1)).findByName(name);
    }

    @Test
    void testSave() {
        // Arrange
        Customer customer = new Customer(1L, "John Doe", "john.doe@example.com");
        when(customerRepository.save(customer)).thenReturn(customer);

        // Act
        Customer savedCustomer = customerService.save(customer);

        // Assert
        assertEquals(customer.getName(), savedCustomer.getName());
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    void testUpdate() {
        // Arrange
        Customer customer = new Customer(1L, "John Doe", "john.doe@example.com");
        when(customerRepository.save(customer)).thenReturn(customer);

        // Act
        Customer updatedCustomer = customerService.update(customer);

        // Assert
        assertEquals(customer.getName(), updatedCustomer.getName());
        verify(customerRepository, times(1)).save(customer);
    }
}
