package com.webprojectv1.notalone.user;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.webprojectv1.notalone.cart.Cart;
import com.webprojectv1.notalone.order.OrderItem;
import com.webprojectv1.notalone.review.Review;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Data
@Entity
public class SiteUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false)
    private String userPw;

    private String userName;

    private String userBirth;

    private String userPhoneNumber;
    
    private String userAddress;

    @OneToOne(mappedBy = "siteUser")
    private Cart cart;

    // @OneToMany(mappedBy = "siteUser")
    // private List<Review> reviewList = new ArrayList<>();

    // 구매자의 주문
    @OneToMany(mappedBy = "siteUser")
    private List<Order> userOrderList = new ArrayList<>();

    // 구매자의 주문상품들
    @OneToMany(mappedBy = "siteUser")
    private List<OrderItem> userOrderItemList = new ArrayList<>();
}
