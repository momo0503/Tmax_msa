package com.example.orderservice.service;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.entity.OrderEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.criteria.Order;
import java.util.UUID;

public class OrderServiceImpl implements OrderService{

    @Override
    public OrderDto createOrder(OrderDto orderDetails) {
       orderDetails.setOrderId(UUID.randomUUID().toString());
       orderDetails.setTotalPrice(orderDetails.getQty() * orderDetails.getUnitPrice());
       ModelMapper modelMapper = new ModelMapper();
       modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

       OrderEntity returnValue = modelMapper.map(orderEntity, OrderDto.class);


        return null;
    }

    @Override
    public OrderDto getOrderByOrderId(String orderId) {
        return null;
    }

    @Override
    public Iterable<OrderEntity> getOrdersByUserId(String userId) {
        return null;
    }
}
