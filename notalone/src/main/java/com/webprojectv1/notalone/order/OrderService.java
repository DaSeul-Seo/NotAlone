package com.webprojectv1.notalone.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webprojectv1.notalone.cart.CartItem;
import com.webprojectv1.notalone.user.SiteUser;

import java.util.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    public void createOrder(SiteUser siteUser){
        orderDao.createOrder(siteUser);
    }

    public void addOrder(SiteUser siteUser, List<OrderItem> orderItemList) {
        orderDao.addOrder(siteUser, orderItemList);
    }

    public OrderItem addCartOrder(long productId, long id, CartItem cartItem) {
        return orderDao.addCartOrder(productId, id, cartItem);
    }

    // id에 해당하는 주문 아이템 찾기
    public List<OrderItem> findUserOrderItemList(long id) {
        return orderDao.findUserOrderItemList(id);
    }

    // C(Insert) & U(Update)
    public void insertOrder(Order orderDto) {
        log.info("[OrderService] Order Insert And Update");
        orderDao.insertOrder(orderDto);
    }

    // R(Select)
    public List<Order> selectOrderAll() {
        log.info("[OrderService] Order Select All");
        List<Order> orderList = orderDao.selectOrderAll();
        return orderList;
    }

    // D(Delete)
    public void deleteOrder(long orderId) {
        log.info("[OrderService] Order Delete");
        orderDao.deleteOrder(orderId);
    }
}
