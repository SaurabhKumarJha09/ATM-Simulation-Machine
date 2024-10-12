package com.atm.ATM.Simulation.Machine.controller;

import com.atm.ATM.Simulation.Machine.model.Bank;
import com.atm.ATM.Simulation.Machine.model.Customer;
import com.atm.ATM.Simulation.Machine.service.BankService;
import com.atm.ATM.Simulation.Machine.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/bank")
public class BankController {
    private BankService bankService;

    @Autowired
    public BankController(BankService bankService){ this.bankService = bankService; }

    @GetMapping("/get-all-bank")
    public ResponseEntity<List<Bank>> getAllBank(){
        List<Bank> banker = bankService.getAllBank();
        return ResponseEntity.ok(banker);
    }

    @GetMapping("/get-bank/{bankId}")
    public ResponseEntity<Bank> getBankById(@PathVariable String bankId){
        Bank bank = bankService.getBankById(bankId);
        return ResponseEntity.ok(bank);
    }


    @PostMapping("/save-bank")
    public ResponseEntity<Bank> saveBank(@RequestBody Bank bank){
        bankService.saveBank(bank);
        return ResponseEntity.ok(bank);
    }

    @PostMapping("/save-banks")
    public ResponseEntity<String> saveBanks(@RequestBody List<Bank> banks){
        bankService.saveBanks(banks);
        return ResponseEntity.ok("The banker are added sucessfully");
    }

    @DeleteMapping("/delete-all-banks")
    public ResponseEntity deleteAllBank(){
        bankService.deleteAllBank();
        return ResponseEntity.ok("All banks are deleted Successfully");
    }

    @DeleteMapping("/delete-bank/{bankId}")
    public ResponseEntity deleteBankById(@PathVariable String bankId){
        bankService.deleteBankById(bankId);
        return ResponseEntity.ok("The bank is removed successfully");
    }




}
