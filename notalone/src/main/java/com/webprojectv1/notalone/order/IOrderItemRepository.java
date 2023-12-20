package com.webprojectv1.notalone.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface IOrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findOrderItemListBySiteUser_Id(long userId);
    OrderItem findOrderItemByOrderItemId(long orderItemId);
}
