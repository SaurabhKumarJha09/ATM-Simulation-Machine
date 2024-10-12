package com.atm.ATM.Simulation.Machine.controller;

import com.atm.ATM.Simulation.Machine.model.Employees;
import com.atm.ATM.Simulation.Machine.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeesController {
    private EmployeesService employeesService;

    @Autowired
    public  EmployeesController(EmployeesService employeesService){
        this.employeesService = employeesService; }

    @GetMapping("/get-all-employees")
    public ResponseEntity<List<Employees>> getAllEmployees(){
        List<Employees> employees = employeesService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/get-employees/{employeeId}")
    public ResponseEntity<Employees> getEmployeeById(@PathVariable String employeeId){
        Employees employees = employeesService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/save-employee")
    public ResponseEntity<Employees> saveEmployee(@RequestBody Employees employees){
        employeesService.saveEmployee(employees);
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/save-employees")
    public ResponseEntity<String> saveEmployees(@RequestBody List<Employees> employees){
        employeesService.saveEmployees(employees);
        return ResponseEntity.ok("Employees are added successfully");
    }

    @DeleteMapping("/delete-all-employees")
    public ResponseEntity deleteAllEmployees(){
        employeesService.deleteAllEmployees();
        return ResponseEntity.ok("All employees are deleted successfully");
    }

    @DeleteMapping("/delete-employee/{employeeId}")
    public ResponseEntity deleteByEmployeeId(@PathVariable String employeeId){
        employeesService.deleteByEmployeeId(employeeId);
        return ResponseEntity.ok("Employee is deleted successfully");
    }

}
