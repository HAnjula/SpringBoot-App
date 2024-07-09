import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomerService} from "../../Service/customer-service";
import {CustomerDto} from "../../dto/CustomerDto";

@Component({
  selector: 'app-delete-customer',
  templateUrl: './delete-customer.component.html',
  styleUrls: ['./delete-customer.component.scss']
})
export class DeleteCustomerComponent implements OnInit{
  deleteForm=new FormGroup({
    id:new FormControl(null,[Validators.required]),
    name:new FormControl(null,[Validators.required]),
    address:new FormControl(null,[Validators.required]),
    salary:new FormControl(null,[Validators.required])
  })

  constructor(private customerService:CustomerService) {}

  ngOnInit() {
  }

  deleteCustomer() {
    this.customerService.deleteCustomer(this.deleteForm.get('id')?.value).subscribe(response=>{
      console.log(response)
      this.deleteForm.patchValue({
        id:null,
        name:null,
        address: null,
        salary: null
      })
    },error => {
      console.log(error)
    })
  }

  getCustomer() {
    this.customerService.getCustomer(this.deleteForm.get('id')?.value).subscribe(response=>{
      console.log(response)
      if (response.object!=null){
        this.deleteForm.patchValue({
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
