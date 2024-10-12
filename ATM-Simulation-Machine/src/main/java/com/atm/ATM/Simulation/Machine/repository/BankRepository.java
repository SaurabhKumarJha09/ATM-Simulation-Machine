package com.atm.ATM.Simulation.Machine.repository;

import com.atm.ATM.Simulation.Machine.model.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org. springframework. data. mongodb. core. query. Query;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BankRepository {
    private MongoTemplate mongoTemplate;

    @Autowired
    public BankRepository(MongoTemplate mongoTemplate){ this.mongoTemplate = mongoTemplate; }

    public List<Bank> getAllBank(){ return mongoTemplate.findAll(Bank.class);}

    public Bank getBankById(String bankId){ return mongoTemplate.findById(bankId ,Bank.class);}

    public void saveBank(Bank bank){ mongoTemplate.save(bank,"Bank");}

    public void saveBanks(List<Bank> banks){
        banks.forEach(bank -> {
            mongoTemplate.save(bank,"Bank");
        });
    }

    public void deleteAllBank(){
        mongoTemplate.remove(new Query(),"Bank");}

   public void deleteBankById(String bankId){
        Query query = new Query();
        query.addCriteria(Criteria.where("bankId").is(bankId));
        mongoTemplate.findAndRemove(query,Bank.class);
   }

}
