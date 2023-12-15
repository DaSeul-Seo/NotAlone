package com.webprojectv1.notalone.product;

import jakarta.persistence.*;
import lombok.Data;


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
    private double productPrice;

    @Column(nullable = false)
    private double productRating;

    @Column(nullable = false)
    private int productStock;
    
    private String productImage;

}