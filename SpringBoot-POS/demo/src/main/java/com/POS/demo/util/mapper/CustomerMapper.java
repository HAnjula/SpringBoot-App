package com.POS.demo.util.mapper;

import com.POS.demo.dto.CustomerDto;
import com.POS.demo.entity.Customer;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring",uses = {CustomerDto.class,Customer.class})
public interface CustomerMapper {
    Customer toCustomer(CustomerDto dto);
    CustomerDto toCustomerDto(Customer customer);
    List<CustomerDto> toCustomerDtoList(Page<Customer> entities);
}
