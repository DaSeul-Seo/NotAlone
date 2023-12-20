package com.webprojectv1.notalone.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderService {
    @Autowired
    private OrderDao purchaseDao;

    // C(Insert) & U(Update)
    public void insertAndUpdatePurchase(Purchase purchaseDto) {
        log.info("[PurchaseService] Purchase Insert And Update");
        purchaseDao.insertAndUpdatePurchase(purchaseDto);
    }

    // R(Select)
    public List<Purchase> selectPurchaseAll() {
        log.info("[PurchaseService] Purchase Select");
        List<Purchase> PurchaseList = purchaseDao.selectUserAll();
        return PurchaseList;
    }

    // D(Delete)
    public void deletePurchase(long purchaseId) {
        log.info("[PurchaseService] Purchase Delete");
        purchaseDao.deletePurchase(purchaseId);
    }
}
