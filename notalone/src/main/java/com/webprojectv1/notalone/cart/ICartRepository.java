package com.webprojectv1.notalone.cart;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartRepository extends JpaRepository<Cart, Long>{
    
}
