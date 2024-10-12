package com.atm.ATM.Simulation.Machine.controller;

import com.atm.ATM.Simulation.Machine.model.Customer;
import com.atm.ATM.Simulation.Machine.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    @GetMapping("/get-all-customer")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> customers = customerService.getAllCustomer();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/get-customer/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable  String customerId){
        Customer customer = customerService.getCustomerById(customerId);
        return ResponseEntity.ok(customer);
    }

    @PostMapping("/save-customer")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return ResponseEntity.ok(customer);
    }

    @PostMapping("/save-customers")
    public ResponseEntity<String> saveCustomers(@RequestBody List<Customer> customers){
        customerService.saveCustomers(customers);
        return ResponseEntity.ok("Customers are added successfully");
    }

    @DeleteMapping("/delete-all-customers")
    public ResponseEntity deleteAllCustomer(){
        customerService.deleteAllCustomer();
        return ResponseEntity.ok("All customers are deleted successfully");
    }

    @DeleteMapping("/delete-customer/{customerId}")
    public ResponseEntity deleteCustomerById(String customerId){
        customerService.deleteCustomerById(customerId);
        return ResponseEntity.ok("The customer is deleted successfully");
    }
}
