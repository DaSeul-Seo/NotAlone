package com.webprojectv1.notalone.product;

import org.springframework.data.jpa.repository.JpaRepository;

// import com.webprojectv1.notalone.cart.Cart;

public interface IProductRepository extends JpaRepository<Product, Long> {
    
}