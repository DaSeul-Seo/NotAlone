package com.webprojectv1.notalone.order;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.webprojectv1.notalone.user.SiteUser;
import com.webprojectv1.notalone.user.UserService;


@Controller
public class OrderController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/mypage/{id}")
    public String orderSelectAll(@PathVariable("id") Long id, Principal principal, Model model) {
        // 로그인이 되어있는 유저의 id와 주문 내역에 접속하는 id가 같아야 함
        SiteUser siteUser = userService.getUser(principal.getName());
        if (siteUser.getId() == id) {
            // 로그인 되어 있는 유저에 해당하는 구매내역 가져오기
            List<OrderItem> orderItemList = orderService.findUserOrderItemList(id);

            // 총 주문 개수
            int totalCount = 0;
            for (OrderItem orderItem : orderItemList) {
                totalCount += orderItem.getOrderCount();
            }

            model.addAttribute("totalCount", totalCount);
            model.addAttribute("orderItemList", orderItemList);
            model.addAttribute("user", userService.selectUserOne(siteUser.getId()));

            return "mypage";
        }
        // 로그인 id와 주문 내역 접속 id가 같지 않는 경우
        else {
            return "redirect:/";
        }
    }
    
    @PostMapping("/mypage/insertOrder")
    public String  insertOrder(Principal principal) {
        SiteUser siteUser = userService.getUser(principal.getName());

        return "";
    }
}
