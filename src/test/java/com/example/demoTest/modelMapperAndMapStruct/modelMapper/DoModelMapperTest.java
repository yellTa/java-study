package com.example.demoTest.modelMapperAndMapStruct.modelMapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DoModelMapperTest {


    @Test
    @DisplayName("modelMapper Test")
    public void modelMapperTest() {
        DoModelMapper doModelMapper = new DoModelMapper();
        OrderDTO orderDTO = doModelMapper.makeOrderDTO();
        System.out.println("the result = "+ orderDTO);
    }
    @Test
    @DisplayName("modelMapper without Setter")
    public void modelMapperTestWithoutSetter() {
        DoModelMapper doModelMapper = new DoModelMapper();
        OrderDTO orderDTO = doModelMapper.makeOrderDTOImmutable();
        System.out.println("the immutable result = "+ orderDTO);
    }



}