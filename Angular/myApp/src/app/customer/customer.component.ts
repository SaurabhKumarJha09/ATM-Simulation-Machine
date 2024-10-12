import { Component, OnInit } from '@angular/core';
import { CustomerService } from './customer.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrl: './customer.component.css'
})
export class CustomerComponent implements OnInit {
  customers : any;
  customerData: any;

  constructor(private customerService: CustomerService){ }

  ngOnInit(): void {
      this.getAllCustomer();
  }

  getAllCustomer(){ 
    this.customerService.getAllCustomer().subscribe((data: any)=> {
      this.customers = data;
    })
  }

  deleteCustomerById(customerId: string){
    this.customerService.deleteCustomerById(customerId).subscribe((data: any) =>{
      console.log("Customer is deleted successfully");
    })
  }

  addCustomerData(customerId: string){
    this.customerService.getCustomerById(customerId).subscribe((data: any) => {
      this.customerData = data;
    })
  }
}
