package com.POS.demo.service;

import com.POS.demo.dto.CustomerDto;
import com.POS.demo.paginated.PaginatedCustomerResponseDto;

import java.util.ArrayList;

public interface CustomerService {
    String saveCustomer(CustomerDto dto);
    String updateCustomer(CustomerDto dto);
    String deleteCustomer(String id);
    CustomerDto getCustomer(String id);
    PaginatedCustomerResponseDto getAllCustomers(int page,
                                                 int size,
                                                 String searchText);
}
