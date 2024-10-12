import { Component, OnInit } from '@angular/core';
import { EmployeeService } from './employee.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css'
})
export class EmployeeComponent implements OnInit {
  employees : any;
  employeeData: any;

  constructor( private employeeService: EmployeeService){ }

  ngOnInit(): void {
      this.getAllEmployees();
  }

  getAllEmployees(){
    this.employeeService.getAllEmployees().subscribe((data: any) => {
        this.employees = data;
    })
  }
  deleteByEmployeeId(employeeId: string){
    this.employeeService.deleteByEmployeeId(employeeId).subscribe((data: any) =>{
      console.log("Employee is deleted successfully");
    })
  }

  addEmployeeData(employeeId: string){
    this.employeeService.getEmployeeById(employeeId).subscribe((data: any) => {
      this.employeeData = data;
    })
  }

}
