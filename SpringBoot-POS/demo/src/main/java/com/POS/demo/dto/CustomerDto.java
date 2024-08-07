package com.POS.demo.dto;

import lombok.*;

//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {
    private String id;
    private String name;
    private String address;
    private Double salary;
}
