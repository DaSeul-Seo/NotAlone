package com.webprojectv1.notalone.user;

import com.webprojectv1.notalone.cart.Cart;
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

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userBirth;

    private String userPhoneNumber;
    
    private String userAddress;

    @Column(nullable = false)
    private char isGrant;

    @OneToMany(mappedBy = "siteuser")
    private List<Cart> cartList;

    @OneToMany(mappedBy = "siteuser")
    private List<Review> reviewList;
}
