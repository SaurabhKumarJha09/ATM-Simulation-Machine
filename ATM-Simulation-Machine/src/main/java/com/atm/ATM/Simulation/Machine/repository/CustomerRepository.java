package com.atm.ATM.Simulation.Machine.repository;

import com.atm.ATM.Simulation.Machine.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {
    @Autowired
    private MongoTemplate mongoTemplate ;


    public CustomerRepository(MongoTemplate mongoTemplate){ this.mongoTemplate = mongoTemplate; }

    public List<Customer> getAllCustomer(){
        return mongoTemplate.findAll(Customer.class);
    }

    public Customer getCustomerById(String customerId) { return mongoTemplate.findById(customerId,Customer.class);}

    public void saveCustomer(Customer customer){mongoTemplate.save(customer,"Customer");}

    public void saveCustomers(List<Customer> customers){
        customers.forEach(customer ->
                mongoTemplate.save(customer,"Customer"));
    }

    public void deleteAllCustomer(){
        mongoTemplate.remove(new Query(),"Customer");
    }

    public void deleteCustomerById(String customerId){
        Query query = new Query();
        query.addCriteria(Criteria.where(customerId).is(customerId));
        mongoTemplate.findAndRemove(query,Customer.class);
    }
 }
