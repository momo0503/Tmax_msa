package com.example.orderservice.jpa;

import com.example.orderservice.entity.OrderEntity;
import org.hibernate.criterion.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<OrderEntity, Long> {

        OrderEntity findByOrderId(String orderId);
        Iterable<OrderEntity> findByUserId(String userId);

}
