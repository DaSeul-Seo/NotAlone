package com.webprojectv1.notalone.cart;

import com.webprojectv1.notalone.product.Product;
import com.webprojectv1.notalone.user.SiteUser;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Data
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;

    @Column(nullable = false)
    private Date cartDate;
    
    private Date purchaseDate;
    
    @Column(nullable = false)
    private int cartCount;
    
    @Column(nullable = false)
    private char isPurchase = '0';

    @ManyToMany
    private List<Product> productList = new ArrayList<>();
    
    @ManyToOne
    private SiteUser siteUser;                                 
}
