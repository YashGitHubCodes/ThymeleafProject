package com.main.handsonjava.service.impl;

import com.main.handsonjava.dto.CustomerDto;
import com.main.handsonjava.entity.CustomerEntity;
import com.main.handsonjava.exception.CustomerAlreadyExistException;
import com.main.handsonjava.exception.CustomerNotFoundException;
import com.main.handsonjava.mapper.CustomerMapper;
import com.main.handsonjava.repository.CustomerRepository;
import com.main.handsonjava.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements ICustomerService {

    CustomerRepository customerRepository;

    @Autowired
    public void CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public void createCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity = CustomerMapper.mapToCustomerEntity(customerDto, new CustomerEntity());
        System.out.println("Customer Phone number is = " + customerEntity.getCustomerPhone());
        Optional<CustomerEntity> optionalCustomer = customerRepository.findByCustomerPhone(customerEntity.getCustomerPhone());

        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistException("Customer Already Exists by phone number " + customerEntity.getCustomerPhone());

        }

        customerRepository.save(customerEntity);
    }

    @Override
    public void deleteCustomer(int id) {
        Optional<CustomerEntity> optionalCustomer = customerRepository.findById(id);

        if (!optionalCustomer.isPresent()) {
            throw new CustomerNotFoundException("Customer with provided mobile number does not exists : " + id);
        }

        customerRepository.delete(optionalCustomer.get());
    }

    @Override
    public List<CustomerDto> fetchAllCustomers() {
        List<CustomerEntity> customerEntities = customerRepository.findAllByOrderByCustomerNameAsc();
        List<CustomerDto> customerDtoList = customerEntities.stream().map(entity -> CustomerMapper.mapToCustomerDto(entity, new CustomerDto())).collect(Collectors.toCollection(ArrayList::new));

        if (customerDtoList.isEmpty()) {
            throw new CustomerNotFoundException("No customers found in the database");
        }

        return customerDtoList;
    }

    @Override
    public void updateCustomer(CustomerDto customerDto) {
        Optional<CustomerEntity> optionalCustomer = customerRepository.findById(customerDto.getCustomerId());


        if (optionalCustomer.isPresent()) {
            CustomerEntity customerEntity = CustomerMapper.mapToCustomerEntity(customerDto, optionalCustomer.get());

            customerRepository.save(customerEntity);
        }
    }

    @Override
    public CustomerDto findById(int customerId) {
        Optional<CustomerEntity> optionalCustomer = customerRepository.findById(customerId);
        return optionalCustomer.map(entity -> CustomerMapper.mapToCustomerDto(entity, new CustomerDto())).orElseThrow(() -> new CustomerNotFoundException("Customer id not found - " + customerId));
    }
}
