package com.webprojectv1.notalone.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    // C(Insert)
    public void insertUpdateProduct(Product productDto) {
        log.info("[ProductService] Product Insert And Update : " + productDto.toString());
        productDao.insertUpdateProduct(productDto);
    }


    // R(Select)
    public List<Product> selectProductAll() {
        List<Product> productList = productDao.selectProductAll();
        
        // 비즈니스 로직 구현
        // dto를 만들면 entity를 dto로 바꾸어서 return

        return productList;
    }

    public Product selectProductOne(long productId) {
        Product productEntity = productDao.selectProductOne(productId);
        
        // 비즈니스 로직 구현
        // dto를 만들면 entity를 dto로 바꾸어서 return

        return productEntity;
    }

    // D(Delete)
    public void deleteProduct(long productId) {
        log.info("[ProductService] Product Delete");
        productDao.deleteProduct(productId);
    }
}
