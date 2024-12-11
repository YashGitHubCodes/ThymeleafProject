package com.main.handsonjava.repository;

import com.main.handsonjava.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface    CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    Optional<CustomerEntity> findByCustomerPhone(String customerPhone);
    public List<CustomerEntity> findAllByOrderByCustomerNameAsc();

}
