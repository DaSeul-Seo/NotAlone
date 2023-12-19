package com.webprojectv1.notalone.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CartService {
    @Autowired
    private CartDao cartDao;

    // C(Insert) & U(Update)
    public void insertAndUpdateUser(Cart cartDto) {
        log.info("[CartService] Cart Insert And Update");
        // cartDto.setPurchaseDate(new Date());
        // cartDto.setProduct(null);
        // cartDto.setUser(null);
        cartDao.insertUpdateCart(cartDto);
    }

    // R(Select)
    public List<Cart> selectCartAll() {
        log.info("[CartService] Cart Select");
        List<Cart> cartList = cartDao.selectCartAll();
        return cartList;
    }

    // D(Delete)
    public void deleteCart(long cartId) {
        log.info("[CartService] Cart Delete");
        cartDao.deleteCart(cartId);
    }
}
