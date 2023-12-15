package com.webprojectv1.notalone.cart;

import java.util.Date;

import com.webprojectv1.notalone.product.Product;
import com.webprojectv1.notalone.user.User;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cartId;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Date purchaseDate;
}
