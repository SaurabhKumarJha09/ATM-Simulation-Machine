package com.atm.ATM.Simulation.Machine.repository;

import com.atm.ATM.Simulation.Machine.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import org. springframework. data. mongodb. core. query. Query;

import java.util.List;

@Repository
public class EmployeesRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public EmployeesRepository(MongoTemplate mongoTemplate){this.mongoTemplate = mongoTemplate;}

    public List<Employees> getAllEmployees(){
        return mongoTemplate.findAll(Employees.class);
    }

    public Employees getEmployeeById(String employeeId){ return mongoTemplate.findById(employeeId,Employees.class); }

    public void saveEmployee(Employees employees){ mongoTemplate.save(employees, "Employees");}

    public void saveEmployees(List<Employees>employees){
        employees.forEach(employees1 -> {
            mongoTemplate.save(employees1,"Employees");
        });
    }

    public void deleteAllEmployees(){
        mongoTemplate.remove(new Query(), "Employees");
    }

    public void deleteByEmployeeId(String employeeId){
        Query query = new Query();
        query.addCriteria(Criteria.where("employeeId").is(employeeId));
        mongoTemplate.findAndRemove(query,Employees.class);
    }
}
