package com.webprojectv1.notalone.cart;

import java.util.Date;

import com.webprojectv1.notalone.product.Product;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartItemId;

    @Column(nullable = false)
    private Date cartDate = new Date();

    @Column(nullable = false)
    private int cartCount;

    @Column(nullable = false)
    // 구매상태 : 구매함 1, 구매안함 0
    private char cartStatus = '0';

    @OneToOne
    private Product product;

    // @ManyToOne
    // private Cart cart;
}
