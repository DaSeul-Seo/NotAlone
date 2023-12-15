package com.webprojectv1.notalone.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "purchase")
@Entity(name = "PurchaseDto")
public class PurchaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long purchaseId;

    @ManyToOne
    @JoinColumn(name = "id")
    @Column(nullable = false)
    private UserDto user;

    @ManyToOne
    @JoinColumn(name = "productId")
    @Column(nullable = false)
    private ProductDto product;

    @Column(nullable = false)
    private String purchaseDate;

    @Column(nullable = false)
    private String purchaseCount;
}
