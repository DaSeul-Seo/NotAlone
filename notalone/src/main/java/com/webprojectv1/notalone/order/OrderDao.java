package com.webprojectv1.notalone.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderDao {
    @Autowired
    private IOrderRepository purchaseRepository;

    // C(Insert) & U(Update)
    // save :  엔티티의 ID가 이미 존재하면 업데이트를 수행하고, 
    //         ID가 없으면 새로운 엔티티를 저장하기 때문에 합침
    public void insertAndUpdatePurchase(Purchase purchaseEntity) {
        log.info("[PurchaseDao] Purchase Insert And Update : " + purchaseEntity.toString());
        purchaseRepository.save(purchaseEntity);
    }

    // R(Select)
    public List<Purchase> selectUserAll() {
        log.info("[PurchaseDao] Purchase Select All");
        // userRepository에서 select * from user;
        List<Purchase> purchaseList = purchaseRepository.findAll();
        return purchaseList;
    }

     // D(Delete) : id
    public void deletePurchase(long purchaseId) {
        Purchase savedpurchase = purchaseRepository.getReferenceById(purchaseId);
        // 삭제하고자 하는 데이터를 DB에서 확인
        if (savedpurchase == null) {
            log.info("[PurchaseDao] Failed Purchase Delete : Does not exist. : " + purchaseId);
            return;
        }
        log.info("Purchase Delete");
        purchaseRepository.deleteById(purchaseId);
    }
}
