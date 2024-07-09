package com.POS.demo.api;

import com.POS.demo.dto.CustomerDto;
import com.POS.demo.paginated.PaginatedCustomerResponseDto;
import com.POS.demo.service.CustomerService;
import com.POS.demo.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerDto dto)
    {
        return new ResponseEntity<>(new StandardResponse(
                201,customerService.saveCustomer(dto)+" saved!",
                customerService.saveCustomer(dto)), HttpStatus.CREATED
        );
    }
    @PutMapping
    public ResponseEntity<StandardResponse> updateCustomer(@RequestBody CustomerDto dto){
        return new ResponseEntity<>(new StandardResponse(
                201,customerService.updateCustomer(dto)+" updated!",
                customerService.saveCustomer(dto)), HttpStatus.CREATED
        );
    }
    @DeleteMapping
    public ResponseEntity<StandardResponse> deleteCustomer(@RequestParam String id){
        return  new ResponseEntity<>(new StandardResponse(
                201,"Customer data",customerService.deleteCustomer(id)),HttpStatus.ACCEPTED
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> getCustomer(@PathVariable String id){
        return  new ResponseEntity<>(new StandardResponse(
                201,"Customer data",customerService.getCustomer(id)),HttpStatus.ACCEPTED
        );
    }
    @GetMapping("/list")
    public  ResponseEntity<StandardResponse>  getAllCustomers(@RequestParam int page,
                                                        @RequestParam int size,
                                                        @RequestParam String searchText){
        return  new ResponseEntity<>(new StandardResponse(
                201,"Customer data",customerService.getAllCustomers(page,size,searchText)),HttpStatus.OK
        );
    }
}
