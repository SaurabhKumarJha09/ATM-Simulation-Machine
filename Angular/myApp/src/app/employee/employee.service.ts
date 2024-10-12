import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient,private router: Router) { }

  getAllEmployees(): Observable<any>{
    return this.http.get(`http://localhost:8080/employees/get-all-employees`);
  }

  getEmployeeById(employeeId: string): Observable<any>{
    return this.http.get(`http://localhost:8080/employees/get-employees/${employeeId}`);
  }

  deleteByEmployeeId(employeeId: string): Observable<any>{
    return this.http.delete(`http://localhost:8080/employees/delete-employee/${employeeId}`);
  }
}
