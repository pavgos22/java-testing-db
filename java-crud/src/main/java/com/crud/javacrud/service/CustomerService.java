package com.crud.javacrud.service;

import com.crud.javacrud.entity.Customer;
import com.crud.javacrud.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    public final CustomerRepository customerRepository;

    public Customer postCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
