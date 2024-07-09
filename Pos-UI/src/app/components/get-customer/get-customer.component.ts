import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomerService} from "../../Service/customer-service";

@Component({
  selector: 'app-get-customer',
  templateUrl: './get-customer.component.html',
  styleUrls: ['./get-customer.component.scss']
})
export class GetCustomerComponent implements OnInit{
  getForm=new FormGroup({
    id:new FormControl(null,[Validators.required]),
    name:new FormControl(null,[Validators.required]),
    address:new FormControl(null,[Validators.required]),
    salary:new FormControl(null,[Validators.required]),
  })

  constructor(private customerService:CustomerService) {}

  ngOnInit() {
  }

  getCustomer() {
    this.customerService.getCustomer(this.getForm.get('id')?.value).subscribe(response=>{
      console.log(response)
      if (response.object!=null){
        this.getForm.patchValue({
          name:response.object.name,
          address: response.object.address,
          salary: response.object.salary
        })
      }else {
        alert('Customer not Found')
      }

    },error => {
      console.log(error)
    })
  }
}
