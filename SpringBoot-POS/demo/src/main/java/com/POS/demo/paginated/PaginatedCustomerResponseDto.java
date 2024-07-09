package com.POS.demo.paginated;

import com.POS.demo.dto.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedCustomerResponseDto {
    private List<CustomerDto> list;
    private long dataCount;
}
