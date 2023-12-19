package com.webprojectv1.notalone.product;

import com.webprojectv1.notalone.cart.Cart;
import com.webprojectv1.notalone.review.Review;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @Column(nullable = false)
    private String productName;

    private String productCategory;

    @Column(nullable = false)
    private int productPrice;

    @Column(nullable = false)
    private double productRating;

    @Column(nullable = false)
    private int productStock;
    
    private String productImage;

    @OneToMany(mappedBy = "product")
    private List<Review> reviewList = new ArrayList<>();

    // @ManyToMany(mappedBy = "productList")
    // private List<Cart> cartList = new ArrayList<>();

}