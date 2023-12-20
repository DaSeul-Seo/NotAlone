package com.webprojectv1.notalone.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface IOrderRepository extends JpaRepository<Order, Long> {
    List<Order> findOrderListBySiteUser_Id(long id);
}
