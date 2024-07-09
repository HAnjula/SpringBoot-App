import { Injectable } from '@angular/core';
import {CustomerDto} from "../dto/CustomerDto";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  constructor(private http:HttpClient) { }
  saveCustomer(customer:CustomerDto):Observable<any>{
    return this.http.post('http://localhost:8080/api/v1/customer',{
      id:customer.id,
      name:customer.name,
      address:customer.address,
      salary:customer.salary
    })
  }

  updateCustomer(customer:CustomerDto):Observable<any>{
    return this.http.put('http://localhost:8080/api/v1/customer',{
      id:customer.id,
      name:customer.name,
      address:customer.address,
      salary:customer.salary
    })
  }
  getCustomer(id:any):Observable<any>{
    return this.http.get('http://localhost:8080/api/v1/customer/'+id)
  }
  deleteCustomer(id:any):Observable<any>{
    return this.http.delete('http://127.0.0.1:8080/api/v1/customer?id='+id)
  }
  getAllCustomers(page:number,size:number,searchText:String):Observable<any>{
    return this.http.get('http://127.0.0.1:8080/api/v1/customer/list?page='+page+"&size="+size+'&searchText='+searchText);
  }
}
