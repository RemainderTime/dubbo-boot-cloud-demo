package com.xf.consumer.dubbo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.xf.consumer.dubbo.service.OrderServiceImpl;
import com.xf.consumer.dubbo.utils.SentinelExceptionUtil;
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
    @SentinelResource(value = "placeAnOrder", fallback = "fallbackHandler", fallbackClass = SentinelExceptionUtil.class,
            blockHandler = "blockExHandler", blockHandlerClass = SentinelExceptionUtil.class)
    public String placeAnOrder() {
        // 模拟用户下单
        orderService.placeAnOrder();
        return "下单成功";
    }
}
