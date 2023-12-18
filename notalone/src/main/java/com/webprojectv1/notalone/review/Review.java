package com.webprojectv1.notalone.review;

import com.webprojectv1.notalone.product.Product;
import com.webprojectv1.notalone.user.SiteUser;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Review {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reviewId;

    // @ManyToOne
    // @JoinColumn(name = "id", nullable = false)
    // private SiteUser user;

    // @ManyToOne
    // @JoinColumn(name = "productId", nullable = false)
    // private Product product;

    @Column(nullable = false)
    private double reviewRating;

    
    @Column(nullable = false)
    private String reviewContent;

}
