package com.webprojectv1.notalone.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "cart")
@Entity(name = "CartDto")
public class CartDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cartId;

    @ManyToOne
    @JoinColumn(name = "id")
    @Column(nullable = false)
    private UserDto user;

    @ManyToOne
    @JoinColumn(name = "productId")
    @Column(nullable = false)
    private ProductDto product;

    @Column(nullable = false)
    private Date purchaseDate;
}
