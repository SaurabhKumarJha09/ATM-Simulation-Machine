package com.atm.ATM.Simulation.Machine.service;

import com.atm.ATM.Simulation.Machine.model.Employees;
import com.atm.ATM.Simulation.Machine.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesService {
    @Autowired
    private EmployeesRepository employeesRepository;

    public EmployeesService(EmployeesRepository employeesRepository){this.employeesRepository = employeesRepository; }

    public List<Employees> getAllEmployees(){ return employeesRepository.getAllEmployees();}

    public Employees getEmployeeById(String employeeId){ return employeesRepository.getEmployeeById(employeeId); }

    public Employees saveEmployee(Employees employees){ employeesRepository.saveEmployee(employees);
        return employees;
    }

    public void saveEmployees(List<Employees>employees){employeesRepository.saveEmployees(employees);}

    public void deleteAllEmployees(){ employeesRepository.deleteAllEmployees();}

    public void deleteByEmployeeId(String employeeId){ employeesRepository.deleteByEmployeeId(employeeId);}
}
