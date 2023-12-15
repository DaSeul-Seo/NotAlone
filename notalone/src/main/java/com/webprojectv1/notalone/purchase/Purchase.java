package com.webprojectv1.notalone.purchase;

import com.webprojectv1.notalone.product.Product;
import com.webprojectv1.notalone.user.User;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long purchaseId;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    @Column(nullable = false)
    private String purchaseDate;

    @Column(nullable = false)
    private String purchaseCount;
}
