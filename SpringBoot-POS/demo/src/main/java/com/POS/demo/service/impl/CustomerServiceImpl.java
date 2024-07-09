package com.POS.demo.service.impl;

import com.POS.demo.dto.CustomerDto;
import com.POS.demo.entity.Customer;
import com.POS.demo.paginated.PaginatedCustomerResponseDto;
import com.POS.demo.repo.CustomerRepo;
import com.POS.demo.service.CustomerService;
import com.POS.demo.util.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo repo;
    @Autowired
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepo repo, CustomerMapper customerMapper) {
        this.repo = repo;
        this.customerMapper = customerMapper;
    }

    @Override
    public String saveCustomer(CustomerDto dto) {
        return
                repo.save(customerMapper.toCustomer(dto))
                        .getName();


    }

    @Override
    public String updateCustomer(CustomerDto dto) {
        Optional<Customer> tempCustomer = repo.findById(dto.getId());
        if (tempCustomer.isPresent()){
            tempCustomer.get().setId(dto.getId());
            tempCustomer.get().setName(dto.getName());
            tempCustomer.get().setAddress(dto.getAddress());
            tempCustomer.get().setSalary(dto.getSalary());
            return repo.save(tempCustomer.get()).getName();
        }
        return "Customer not found equal to "+dto.getId();
    }

    @Override
    public String deleteCustomer(String id) {
        Optional<Customer> tempCustomer = repo.findById(id);
        if (tempCustomer.isPresent()){
            repo.delete(tempCustomer.get());
            return id+" Deleted";
        }else {
            return "Customer not found";
        }
    }

    @Override
    public CustomerDto getCustomer(String id) {
        Optional<Customer> customerData = repo.findById(id);
        return customerData.map(customer -> customerMapper.toCustomerDto(customer)).orElse(null);
    }

    @Override
    public PaginatedCustomerResponseDto getAllCustomers(int page, int size, String searchText) {
        List<Customer> list=repo.findAll();
        ArrayList<CustomerDto> dtos=new ArrayList<>();
        for (Customer c:list) {
            dtos.add(new CustomerDto(c.getId(),c.getName(),c.getAddress(),c.getSalary()));
        }
        return new PaginatedCustomerResponseDto(dtos,list.size());
//        return new PaginatedCustomerResponseDto(
//            customerMapper.toCustomerDtoList(repo.getAll(searchText, PageRequest.of(page, size))),
//                repo.getAllCount(searchText)
//        );
    }
}
