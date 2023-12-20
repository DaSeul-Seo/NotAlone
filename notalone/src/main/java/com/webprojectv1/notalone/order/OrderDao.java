package com.webprojectv1.notalone.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webprojectv1.notalone.cart.CartItem;
import com.webprojectv1.notalone.user.IUserRepository;
import com.webprojectv1.notalone.user.SiteUser;

import java.util.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderDao {
    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private IOrderItemRepository orderItemRepository;

    @Autowired
    private IUserRepository userRepository;

    public void createOrder(SiteUser siteUser){
        Order order = Order.createOrder(siteUser);
        orderRepository.save(order);
    }

    public void addOrder(SiteUser siteUser, List<OrderItem> orderItemList) {
        Order userOrder = Order.createOrder(siteUser, orderItemList);
        orderRepository.save(userOrder);
    }

    public OrderItem addCartOrder(long productId, long id, CartItem cartItem) {
        SiteUser siteUser = userRepository.getReferenceById(id);
        OrderItem orderItem = OrderItem.createOrderItem(productId, siteUser, cartItem);
        orderItemRepository.save(orderItem);
        return orderItem;
    }

    public List<OrderItem> findUserOrderItemList(long id) {
        return orderItemRepository.findOrderItemListBySiteUser_Id(id);
    }

    // C(Insert) & U(Update)
    public void insertOrder(Order orderEntity) {
        log.info("[OrderDao] Order : " + orderEntity.toString());
        orderRepository.save(orderEntity);
    }

    // R(Select)
    public List<Order> selectOrderAll() {
        log.info("[OrderDao] Order Select All");
        List<Order> OrderList = orderRepository.findAll();
        return OrderList;
    }

     // D(Delete) : id
    public void deleteOrder(long orderId) {
        Order savedOrder = orderRepository.getReferenceById(orderId);
        // 삭제하고자 하는 데이터를 DB에서 확인
        if (savedOrder == null) {
            log.info("[OrderDao] Failed Order Delete : Does not exist. : " + orderId);
            return;
        }
        log.info("Order Delete");
        orderRepository.deleteById(orderId);
    }
}
