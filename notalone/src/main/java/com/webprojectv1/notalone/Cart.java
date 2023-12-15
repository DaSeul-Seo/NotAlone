package com.webprojectv1.notalone;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cartId;

    @ManyToOne
    @JoinColumn(name = "id")
    @Column(nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "productId")
    @Column(nullable = false)
    private Product product;

    @Column(nullable = false)
    private Date purchaseDate;
}
