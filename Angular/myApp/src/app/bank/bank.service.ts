import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BankService {

  constructor(private http: HttpClient, private router: Router) { }

  getAllBank() : Observable<any>{
    return this.http.get(`http://localhost:8080/bank/get-all-bank`);
  }

  deleteBankById(bankId: string): Observable<any>{
    return this.http.delete(`http://localhost:8080/bank/delete-bank/${bankId}`);
  }

  getBankById(bankId: string): Observable<any>{
    return this.http.get(`http://localhost:8080/bank/get-bank/${bankId}`);
  }
}
