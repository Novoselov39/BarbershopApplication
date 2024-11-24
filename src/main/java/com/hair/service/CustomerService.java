package com.hair.service;

import com.hair.repository.CustomerRepository;
import com.hair.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    public Optional<Customer> create(Customer customer) {
        return Optional.of(customerRepository.save(customer));
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    public Optional<Customer> update(Customer customer) {
        Optional<Customer> cust = customerRepository.findById(customer.getId());
        if (cust.isPresent()) {
            cust.get().setName(customer.getName());
            cust.get().setPhone(customer.getPhone());

        }
        return cust;
    }
}
