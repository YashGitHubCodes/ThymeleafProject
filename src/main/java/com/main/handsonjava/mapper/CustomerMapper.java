package com.main.handsonjava.mapper;

import com.main.handsonjava.dto.CustomerDto;
import com.main.handsonjava.entity.CustomerEntity;

public class CustomerMapper {

    public static CustomerEntity mapToCustomerEntity(CustomerDto customerDto , CustomerEntity customerEntity) {
        customerEntity.setCustomerId(customerDto.getCustomerId());
        customerEntity.setCustomerName(customerDto.getCustomerName());
        customerEntity.setCustomerEmail(customerDto.getCustomerEmail());
        customerEntity.setCustomerAddress(customerDto.getCustomerAddress());
        customerEntity.setCustomerPhone(customerDto.getCustomerPhone());
        customerEntity.setCustomerCity(customerDto.getCustomerCity());
        customerEntity.setCustomerState(customerDto.getCustomerState());
        customerEntity.setCustomerZipcode(customerDto.getCustomerZipcode());
        return customerEntity;
    }


    public static CustomerDto mapToCustomerDto(CustomerEntity customerEntity, CustomerDto customerDto) {
        customerDto.setCustomerId(customerEntity.getCustomerId());
        customerDto.setCustomerName(customerEntity.getCustomerName());
        customerDto.setCustomerEmail(customerEntity.getCustomerEmail());
        customerDto.setCustomerAddress(customerEntity.getCustomerAddress());
        customerDto.setCustomerPhone(customerEntity.getCustomerPhone());
        customerDto.setCustomerCity(customerEntity.getCustomerCity());
        customerDto.setCustomerState(customerEntity.getCustomerState());
        customerDto.setCustomerZipcode(customerEntity.getCustomerZipcode());
        return customerDto;
    }

}