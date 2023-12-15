package com.webprojectv1.notalone;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.webprojectv1.notalone.cart.Cart;
import com.webprojectv1.notalone.cart.CartService;
import com.webprojectv1.notalone.product.ProductService;

@Controller
public class MainController {

        @Autowired
        private ProductService productService;
        @Autowired
        private CartService cartService;

    @GetMapping("/")    
    public String front(Model model){
        model.addAttribute("productList", productService.selectProductAll());
        
            return "index";
    }

    @GetMapping(value = "/product/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("product", productService.selectProductOne(id));
        return "product-detail";
    }

    @GetMapping("/login")    
    public String login(){
            return "login";
    }

    @GetMapping("/join")    
    public String join(){
            return "join";
    }

    @GetMapping("/admin")    
    public String admin(Model model){
        model.addAttribute("productList", productService.selectProductAll());

            return "admin";
    }

    @GetMapping("/cart")    
    public String cart(Model model){
        model.addAttribute("cartList", cartService.selectCartAll());
        return "cart";
    }

    @GetMapping("/cartinsert")    
    public void cartinsert(@ModelAttribute Cart cartDto){
        cartDto.setPurchaseDate(new Date());
        cartService.insertAndUpdateUser(cartDto);
    }
}
