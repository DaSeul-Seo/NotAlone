package com.webprojectv1.notalone.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartItemService cartItemService;

    @GetMapping
    public String getcartItemList(Model model){
        model.addAttribute("cartItemList", cartItemService.selectCartItemAll());
        return "cart";
    }

    @PostMapping("/saveCart")    
    public String saveCartItem(@ModelAttribute CartItem cartItemDto){
        log.info("saveCart");
        cartItemService.insertUpdateCartItem(cartItemDto);
        return "redirect:/";
    }

    @PostMapping("/update")    
    public String updateCartItem(@ModelAttribute CartItem cartItemDto){
        log.info("updateCartItem");
        cartItemService.insertUpdateCartItem(cartItemDto);
        return "redirect:/";
    }

    @PostMapping("/delete")    
    public String deleteCartItem(@ModelAttribute CartItem cartItemDto){
        log.info("deleteCartItem");
        cartItemService.deleteCartItem(cartItemDto.getCartItemId());
        return "redirect:/";
    }
}
