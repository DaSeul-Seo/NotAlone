package com.webprojectv1.notalone.order;

import com.webprojectv1.notalone.cart.CartItem;
import com.webprojectv1.notalone.user.SiteUser;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Data
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private SiteUser siteUser; // 구매자

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItemList = new ArrayList<>();

    @Column(nullable = false)
    private Date orderDate = new Date();

    public void addOrderItem(OrderItem orderItem) {
        orderItemList.add(orderItem);
        orderItem.setOrder(this);
    }

    public static Order createOrder(SiteUser siteUser, List<OrderItem> orderItemList) {
        Order order = new Order();
        order.setSiteUser(siteUser);
        for (OrderItem orderItem : orderItemList) {
            order.addOrderItem(orderItem);
        }
        order.setOrderDate(order.orderDate);
        return order;
    }

    public static Order createOrder(SiteUser siteUser) {
        Order order = new Order();
        order.setSiteUser(siteUser);
        order.setOrderDate(order.orderDate);
        return order;
    }

}
