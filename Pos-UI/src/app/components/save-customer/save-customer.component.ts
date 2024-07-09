import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomerDto} from "../../dto/CustomerDto";
import {CustomerService} from "../../Service/customer-service";

@Component({
  selector: 'app-save-customer',
  templateUrl: './save-customer.component.html',
  styleUrls: ['./save-customer.component.scss']
})
export class SaveCustomerComponent implements OnInit{
    saveForm=new FormGroup({
      id:new FormControl(null,[Validators.required]),
      name:new FormControl(null,[Validators.required]),
      address:new FormControl(null,[Validators.required]),
      salary:new FormControl(null,[Validators.required])
    })

  constructor(private customerService:CustomerService) {}

  ngOnInit() {
  }

  saveCustomer() {
      let customer=new CustomerDto(
        this.saveForm.get('id')?.value,
        this.saveForm.get('name')?.value,
        this.saveForm.get('address')?.value,
        Number(this.saveForm.get('salary')?.value)
      );
    this.customerService.saveCustomer(customer).subscribe(response=>{
      console.log(response)
      this.saveForm.patchValue({
        id:null,
        name:null,
        address: null,
        salary: null
      })
    },error => {
      console.log(error)
    })
  }
}
