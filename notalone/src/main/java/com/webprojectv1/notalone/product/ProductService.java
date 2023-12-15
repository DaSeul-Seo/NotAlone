package com.webprojectv1.notalone.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groovy.util.logging.Slf4j;

@Slf4j
@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;
}
