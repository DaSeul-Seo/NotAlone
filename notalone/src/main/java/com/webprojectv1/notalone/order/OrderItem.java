package com.webprojectv1.notalone.order;

import com.webprojectv1.notalone.cart.CartItem;
import com.webprojectv1.notalone.user.SiteUser;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="orderId")
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private SiteUser siteUser; // 구매자

    // @ManyToOne(fetch = FetchType.EAGER)
    // @JoinColumn(name="item_id")
    // private Item item;

    private Long productId; // 주문 상품 번호
    private String productName; // 주문 상품 이름
    private int productPrice; // 주문 상품 가격
    private int orderCount; // 주문 상품 수량
    private int productTotalPrice; // 가격*수량

    // @OneToOne(fetch = FetchType.EAGER)
    // @JoinColumn(name="saleItem_id")
    // private SaleItem saleItem; // 주문상품에 매핑되는 판매상품

    // private int isCancel; // 주문 취소 여부 (0:주문완료 / 1:주문취소)

    // 장바구니 전체 주문
    public static OrderItem createOrderItem(Long productId, SiteUser siteUser, CartItem cartItem) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProductId(productId);
        orderItem.setSiteUser(siteUser);
        orderItem.setProductName(cartItem.getProduct().getProductName());
        orderItem.setProductPrice(cartItem.getProduct().getProductPrice());
        orderItem.setOrderCount(cartItem.getCartItemCount());
        orderItem.setProductTotalPrice(cartItem.getProduct().getProductPrice()*cartItem.getCartItemCount());
        return orderItem;
    }

    // // 상품 개별 주문
    // public static OrderItem createOrderItem(Long productId, SiteUser siteUser, Product product, int count, Order order, SaleItem saleItem) {
    //     OrderItem orderItem = new OrderItem();
    //     orderItem.setItemId(itemId);
    //     orderItem.setUser(user);
    //     orderItem.setOrder(order);
    //     orderItem.setItemName(item.getName());
    //     orderItem.setItemPrice(item.getPrice());
    //     orderItem.setItemCount(count);
    //     orderItem.setItemTotalPrice(item.getPrice()*count);
    //     orderItem.setSaleItem(saleItem);
    //     return orderItem;
    // }

}
