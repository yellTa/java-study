package com.example.demoTest.modelMapperAndMapStruct.modelMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
public class Order {
    Customer customer;
    Address billingAddress;
}
