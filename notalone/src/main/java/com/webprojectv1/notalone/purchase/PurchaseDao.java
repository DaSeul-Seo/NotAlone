package com.webprojectv1.notalone.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groovy.util.logging.Slf4j;

@Slf4j
@Service
public class PurchaseDao {
    @Autowired
    private IPurchaseRepository purchaseRepository;
}
