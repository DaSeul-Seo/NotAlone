package com.webprojectv1.notalone;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
    @GetMapping("/")    
    public String front(){
            return "index";
    }

    @GetMapping(value = "/product/detail/{id}")
    public String detail(@PathVariable("id") Integer id) {
            return "product-detail";
    }

}
