package com.webprojectv1.notalone.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "review")
@Entity(name = "ReviewDto")
public class ReviewDto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long reviewId;

    @ManyToOne
    @JoinColumn(name = "id")
    @Column(nullable = false)
    private UserDto user;

    @ManyToOne
    @JoinColumn(name = "productId")
    @Column(nullable = false)
    private ProductDto product;

    @Column(nullable = false)
    private double reviewRating;

    
    @Column(nullable = false)
    private String reviewContent;

}
