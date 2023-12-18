package com.webprojectv1.notalone.purchase;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long purchaseId;

    // @ManyToOne
    // @JoinColumn(name = "id", nullable = false)
    // private SiteUser user;

    // @OneToMany
    // @JoinColumn(name = "productId", nullable = false)
    // private Product product;

    // @Column(nullable = false)
    // private Date purchaseDate;

    // @Column(nullable = false)
    // private int purchaseCount;
}
