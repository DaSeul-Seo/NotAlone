package com.webprojectv1.notalone.cart;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

import com.webprojectv1.notalone.user.SiteUser;

@Data
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;
    
    @ManyToOne
    private SiteUser siteUser;
    
    @OneToMany
    private List<CartItem> cartItemList = new ArrayList<>();
}
