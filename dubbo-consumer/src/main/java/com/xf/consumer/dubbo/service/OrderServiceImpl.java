package com.xf.consumer.dubbo.service;

import com.xf.api.DemoService;
import com.xf.consumer.dubbo.mapper.OrderMapper;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * packageName com.xf.consumer.dubbo.service
 * @author remaindertime
 * @className OrderServiceImpl
 * @date 2024/11/14
 * @description
 */
@Service
public class OrderServiceImpl {

    @DubboReference
    private DemoService demoService;

    @Autowired
    private OrderMapper orderMapper;

    @GlobalTransactional(name = "seata-order-service", rollbackFor = Exception.class)
    public String placeAnOrder() {
        // 调用扣减库存的方法
        demoService.deInventory(1, 1);
        // 调用创建订单的方法
        createOrder(1, 1);
//        throw new RuntimeException("测试回滚");
        return "创建订单成功";
    }

    public void createOrder(Integer userId, Integer productId) {

        orderMapper.createOrder(userId, productId);
    }
}
