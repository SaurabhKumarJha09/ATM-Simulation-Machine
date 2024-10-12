import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerComponent } from './customer/customer.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { BankComponent } from './bank/bank.component';
import { EmployeeComponent } from './employee/employee.component';

const routes: Routes = [
  {path: "customer",component:CustomerComponent},
  {path: "home",component:HomeComponent},
  {path: "navbar",component:NavbarComponent},
  {path: "bank",component:BankComponent},
  {path: "employee",component:EmployeeComponent}
];

@NgModule({
  declarations:[],
  imports: [
    RouterModule.forRoot(routes),
    CommonModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
