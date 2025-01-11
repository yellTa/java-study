package com.example.demoTest.modelMapperAndMapStruct.modelMapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

public class DoModelMapper {

	//getter와 setter를 사용하는 modelMapper
	public OrderDTO makeOrderDTO() {
		Order order = new Order(new Customer(new Name("LastName", "FirstName")), new Address("street", "myhouse"));

		//ModelMapper
		ModelMapper mapper = new ModelMapper();

		mapper.typeMap(Order.class, OrderDTO.class)
			  .addMappings(m -> {
				  m.map(src -> src.getCustomer()
								  .getName()
								  .getFirstName(), OrderDTO::setCustomerFirstName);
				  m.map(src -> src.getCustomer()
								  .getName()
								  .getLastName(), OrderDTO::setCustomerLastName);

				  // Address -> billingStreet, billingCity 매핑
				  m.map(src -> src.getBillingAddress()
								  .getStreet(), OrderDTO::setBillingStreet);
				  m.map(src -> src.getBillingAddress()
								  .getCity(), OrderDTO::setBillingCity);
			  });

		return mapper.map(order, OrderDTO.class);
	}

	//접근제한자를 상수로 설정한다.(private final)
	//setter는 사용하지 않는다.
	//OrderDTO는 @Builder 애노테이션이 필요하다.
	public OrderDTO makeOrderDTOImmutable() {
		Order order = new Order(new Customer(new Name("LastName", "FirstName")), new Address("street", "myhouse"));
		ModelMapper mapper = new ModelMapper();

		mapper.typeMap(Order.class, OrderDTO.class)
			  .setProvider(request -> {
				  Order source = (Order)request.getSource();

				  return OrderDTO.builder()
								 .customerFirstName(source.getCustomer()
														  .getName()
														  .getFirstName())
								 .customerLastName(source.getCustomer()
														 .getName()
														 .getLastName())
								 .billingCity(source.getBillingAddress()
													.getCity())
								 .billingStreet(source.getBillingAddress()
													  .getStreet())
								 .build();
			  });
		return mapper.map(order, OrderDTO.class);
	}

}
