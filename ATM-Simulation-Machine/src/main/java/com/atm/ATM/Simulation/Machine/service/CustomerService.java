package com.atm.ATM.Simulation.Machine.service;

import com.atm.ATM.Simulation.Machine.model.Customer;
import com.atm.ATM.Simulation.Machine.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){ this.customerRepository = customerRepository; }

    public List<Customer> getAllCustomer(){ return customerRepository.getAllCustomer(); }

    public Customer getCustomerById(String customerId){ return customerRepository.getCustomerById(customerId);}

    public Customer saveCustomer(Customer customer){
        customerRepository.saveCustomer(customer);
        return customer;
    }

    public void saveCustomers(List<Customer> customers){
        customerRepository.saveCustomers(customers);
    }

    public void deleteAllCustomer(){customerRepository.deleteAllCustomer();}

    public void deleteCustomerById(String customerId) { customerRepository.deleteCustomerById(customerId); }
}
