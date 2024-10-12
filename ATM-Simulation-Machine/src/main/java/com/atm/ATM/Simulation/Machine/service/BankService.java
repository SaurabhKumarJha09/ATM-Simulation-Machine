package com.atm.ATM.Simulation.Machine.service;

import com.atm.ATM.Simulation.Machine.model.Bank;
import com.atm.ATM.Simulation.Machine.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {
    private BankRepository bankRepository;

    @Autowired
    public BankService(BankRepository bankRepository){ this.bankRepository = bankRepository; }

    public List<Bank> getAllBank(){ return bankRepository.getAllBank(); }

    public Bank getBankById(String bankId){ return bankRepository.getBankById(bankId); }

    public Bank saveBank(Bank bank){ bankRepository.saveBank(bank);
        return bank;
    }

    public void saveBanks(List<Bank> banks) {  bankRepository.saveBanks(banks); }

    public void deleteAllBank(){ bankRepository.deleteAllBank();}

    public void deleteBankById(String bankId){ bankRepository.deleteBankById(bankId); }
}
