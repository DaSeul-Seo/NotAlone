package com.webprojectv1.notalone;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long purchaseId;

    @ManyToOne
    @JoinColumn(name = "id")
    @Column(nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "productId")
    @Column(nullable = false)
    private Product product;

    @Column(nullable = false)
    private String purchaseDate;

    @Column(nullable = false)
    private String purchaseCount;
}
