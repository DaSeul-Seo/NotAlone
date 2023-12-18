package com.webprojectv1.notalone.cart;

import com.webprojectv1.notalone.product.Product;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Data
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;

    @OneToMany(mappedBy = "cart")
    private List<Product> product;

    @Column(nullable = false)
    private Date cartDate;
    
    private Date purchaseDate;

    @Column(nullable = false)
    private int cartCount;
}
