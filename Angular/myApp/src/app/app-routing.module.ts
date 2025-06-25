import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerComponent } from './customer/customer.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { BankComponent } from './bank/bank.component';
import { EmployeeComponent } from './employee/employee.component';
import { CardComponent } from './card/card.component';
import { ContactComponent } from './contact/contact.component';
import { AboutComponent } from './about/about.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  {path: "customer",component:CustomerComponent},
  {path: "home",component:HomeComponent},
  {path: "navbar",component:NavbarComponent},
  {path: "bank",component:BankComponent},
  {path: "employee",component:EmployeeComponent},
  {path: "card",component:CardComponent},
  {path: "about",component:AboutComponent},
  {path: "contact",component:ContactComponent},

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
