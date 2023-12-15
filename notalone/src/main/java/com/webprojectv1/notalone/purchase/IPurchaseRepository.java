package com.webprojectv1.notalone.purchase;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPurchaseRepository extends JpaRepository<Purchase, Long> {
    
}
