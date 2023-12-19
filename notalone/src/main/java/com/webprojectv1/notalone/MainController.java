package com.webprojectv1.notalone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import java.security.Principal;

import com.webprojectv1.notalone.cart.CartService;
import com.webprojectv1.notalone.product.ProductService;
import com.webprojectv1.notalone.user.SiteUser;
import com.webprojectv1.notalone.user.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String front(Model model) {
        model.addAttribute("productList", productService.selectProductAll());
        return "index";
    }

    @GetMapping(value = "/product/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("product", productService.selectProductOne(id));
        return "product-detail";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("productList", productService.selectProductAll());

        return "admin";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/mypage")
    public String mypage(Model model, Principal principal) {
        SiteUser user = userService.getUser(principal.getName());
        model.addAttribute("user", user);
        return "mypage";
    }

}
