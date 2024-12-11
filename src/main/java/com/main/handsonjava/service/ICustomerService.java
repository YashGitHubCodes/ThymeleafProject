package com.main.handsonjava.service;

import com.main.handsonjava.dto.CustomerDto;
import jakarta.validation.Valid;

import java.util.List;

public interface ICustomerService {

    void createCustomer(CustomerDto customerDto);

    void deleteCustomer(int id);

    List<CustomerDto> fetchAllCustomers();

    void updateCustomer(@Valid CustomerDto customerDto);

    CustomerDto findById(int customerId);
}
