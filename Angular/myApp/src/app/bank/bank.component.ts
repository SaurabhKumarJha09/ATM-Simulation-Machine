import { Component, OnInit } from '@angular/core';
import { BankService } from './bank.service';

@Component({
  selector: 'app-bank',
  templateUrl: './bank.component.html',
  styleUrl: './bank.component.css'
})
export class BankComponent implements OnInit {
  bank : any;
  bankData: any;

  constructor(private bankService: BankService){}

  ngOnInit(): void {
      this.getAllBank();
  }

  getAllBank(){
    this.bankService.getAllBank().subscribe((data: any)=> {
      this.bank = data;
    })
  }
  deleteBankById(bankId: string){
    this.bankService.deleteBankById(bankId).subscribe((data: any)=>{
      console.log("Bank is deleted successfully")
    })
  }

  addBankData(bankId: string){
    this.bankService.getBankById(bankId).subscribe((data: any) => {
      this.bankData = data;
    })
  }
}