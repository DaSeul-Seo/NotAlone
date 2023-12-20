package com.webprojectv1.notalone.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import com.webprojectv1.notalone.user.SiteUser;
import com.webprojectv1.notalone.user.UserService;

import lombok.extern.slf4j.Slf4j;
import java.util.*;

@Slf4j
@Controller
public class PurchaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/mypage/{id}")
    public String purchaseSelectAll(@PathVariable("id") Long id, Principal principal, Model model) {
        // 로그인이 되어있는 유저의 id와 주문 내역에 접속하는 id가 같아야 함
        SiteUser siteUser = userService.getUser(principal.getName());
        if (siteUser.getId() == id) {
            // 로그인 되어 있는 유저에 해당하는 구매내역 가져오기
            List<PurchaseItem> purchaseItemList = purchaseService.findUserPurchaseItemList(id);

            // 총 주문 개수
            int totalCount = 0;
            for (PurchaseItem purchaseItem : purchaseItemList) {
                totalCount += purchaseItem.getPurchaseCount();
            }

            model.addAttribute("totalCount", totalCount);
            model.addAttribute("purchaseItemList", purchaseItemList);
            model.addAttribute("user", userService.selectUserOne(siteUser.getId()));

            return "mypage";
        }
        // 로그인 id와 주문 내역 접속 id가 같지 않는 경우
        else {
            return "redirect:/";
        }
    }
    
    @PostMapping("/mypage/insertPurchase")
    public String  insertPurchase(Principal principal) {
        SiteUser siteUser = userService.getUser(principal.getName());

        return "";
    }
}
