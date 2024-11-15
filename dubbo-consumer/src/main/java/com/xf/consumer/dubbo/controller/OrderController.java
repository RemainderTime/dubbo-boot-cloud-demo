package com.xf.consumer.dubbo.controller;

import com.xf.consumer.dubbo.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName com.xf.consumer.dubbo.controller
 * @author remaindertime
 * @className OrderController
 * @date 2024/11/15
 * @description
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/placeAnOrder")
    public String placeAnOrder() {
        orderService.placeAnOrder();
        return "下单成功";
    }
}
