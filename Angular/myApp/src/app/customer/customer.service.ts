import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient, private router: Router) { }

  getAllCustomer(): Observable<any>{
    return this.http.get("http://localhost:8080/customer/get-all-customer");
  }

  getCustomerById(customerId: string): Observable<any>{
    return this.http.get(`http://localhost:8080/customer/get-customer/${customerId}`);
  }

  deleteCustomerById(customerId: string): Observable<any>{
    return this.http.delete(`http://localhost:8080/customer/delete-customer/${customerId}`);
  }
}
  