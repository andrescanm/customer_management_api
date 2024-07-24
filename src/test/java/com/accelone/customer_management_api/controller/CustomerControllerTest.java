package com.accelone.customer_management_api.controller;

import com.accelone.customer_management_api.service.CustomerService;
import com.accelone.customer_management_api.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class CustomerControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    void testFindAll() throws Exception {
        // Arrange
        Customer customer1 = new Customer(1L, "John Doe", "john.doe@example.com");
        Customer customer2 = new Customer(2L, "Jane Smith", "jane.smith@example.com");
        when(customerService.findAll()).thenReturn(Arrays.asList(customer1, customer2));

        // Act
        mockMvc.perform(get("/customers")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("John Doe"))
                .andExpect(jsonPath("$[1].name").value("Jane Smith"));

        // Assert
        verify(customerService, times(1)).findAll();
    }

    @Test
    void testFindByName() throws Exception {
        // Arrange
        String name = "John Doe";
        Customer customer = new Customer(1L, name, "john.doe@example.com");
        when(customerService.findByName(name)).thenReturn(Optional.of(customer));

        // Act
        mockMvc.perform(get("/customers/{name}", name)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(name));

        // Assert
        verify(customerService, times(1)).findByName(name);
    }

    @Test
    void testSave() throws Exception {
        // Arrange
        Customer customer = new Customer(1L, "John Doe", "john.doe@example.com");
        when(customerService.save(any(Customer.class))).thenReturn(customer);

        // Act
        mockMvc.perform(post("/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"John Doe\", \"email\": \"john.doe@example.com\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"));

        // Assert
        verify(customerService, times(1)).save(any(Customer.class));
    }

    @Test
    void testUpdate() throws Exception {
        // Arrange
        Customer customer = new Customer(1L, "John Doe", "john.doe@example.com");
        when(customerService.update(any(Customer.class))).thenReturn(customer);

        // Act
        mockMvc.perform(put("/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 1, \"name\": \"John Doe\", \"email\": \"john.doe@example.com\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"));

        // Assert
        verify(customerService, times(1)).update(any(Customer.class));
    }
}
