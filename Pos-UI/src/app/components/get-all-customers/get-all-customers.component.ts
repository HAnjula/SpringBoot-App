import {Component, OnInit} from '@angular/core';
import {CustomerService} from "../../Service/customer-service";

@Component({
  selector: 'app-get-all-customers',
  templateUrl: './get-all-customers.component.html',
  styleUrls: ['./get-all-customers.component.scss']
})
export class GetAllCustomersComponent implements OnInit{
  object:any[]=[]
  constructor(private customerService:CustomerService) {
  }
  ngOnInit() {
    this.loadAllData()
  }

  private loadAllData() {
    this.customerService.getAllCustomers(1,1,"nimal").subscribe(response=>{
      this.object=response.object.list
    })
  }
}
