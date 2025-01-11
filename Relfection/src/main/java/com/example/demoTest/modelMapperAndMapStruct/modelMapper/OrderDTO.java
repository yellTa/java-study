package com.example.demoTest.modelMapperAndMapStruct.modelMapper;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDTO {
	private String customerFirstName;
	private String customerLastName;
	private String billingStreet;
	private String billingCity;
}
