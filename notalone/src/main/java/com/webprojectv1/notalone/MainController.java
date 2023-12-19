package com.webprojectv1.notalone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.webprojectv1.notalone.product.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {

    @Autowired
    private ProductService productService;
    

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

    @GetMapping("/mypage")    
    public String mypage(){
        return "mypage";
    }

}
