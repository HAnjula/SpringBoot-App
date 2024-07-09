package com.POS.demo.util.mapper;

import com.POS.demo.dto.CustomerDto;
import com.POS.demo.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-06T18:23:17+0530",
    comments = "version: 1.6.0.Beta2, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toCustomer(CustomerDto dto) {
        if ( dto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( dto.getId() );
        customer.setName( dto.getName() );
        customer.setAddress( dto.getAddress() );
        customer.setSalary( dto.getSalary() );

        return customer;
    }

    @Override
    public CustomerDto toCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setId( customer.getId() );
        customerDto.setName( customer.getName() );
        customerDto.setAddress( customer.getAddress() );
        customerDto.setSalary( customer.getSalary() );

        return customerDto;
    }

    @Override
    public List<CustomerDto> toCustomerDtoList(Page<Customer> entities) {
        if ( entities == null ) {
            return null;
        }

        List<CustomerDto> list = new ArrayList<CustomerDto>();
        for ( Customer customer : entities ) {
            list.add( toCustomerDto( customer ) );
        }

        return list;
    }
}
