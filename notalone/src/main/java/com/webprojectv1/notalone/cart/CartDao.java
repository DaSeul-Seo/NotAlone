package com.webprojectv1.notalone.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CartDao {
    @Autowired
    private ICartRepository cartRepository;

    // C(Insert) & U(Update)
    // save :  엔티티의 ID가 이미 존재하면 업데이트를 수행하고, 
    //         ID가 없으면 새로운 엔티티를 저장하기 때문에 합침
    public void insertUpdateCart(Cart cartEntity) {
        log.info("[CartDao] Cart Insert And Update : " + cartEntity.toString());
        cartRepository.save(cartEntity);
        
    }

    // R(Select)
    public List<Cart> selectCartAll() {
        log.info("[CartDao] Cart Select All");
        List<Cart> cartList = cartRepository.findAll();
        return cartList;
    }

     // D(Delete) : id
    public void deleteCart(long cartId) {
        Cart savedCart = cartRepository.getReferenceById(cartId);
        // 삭제하고자 하는 데이터를 DB에서 확인
        if (savedCart == null) {
            log.info("[CartDao] Failed User Delete : Does not exist. : " + cartId);
            return;
        }
        log.info("Cart Delete");
        cartRepository.deleteById(cartId);
    }
}
