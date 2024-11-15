package com.example.producer.dubbo.service;

import com.example.producer.dubbo.mapper.DemoMapper;
import com.xf.api.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService
@Slf4j
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

    @Override
    public void deInventory(Integer num, Integer productId) {
        demoMapper.deInventory(num, productId);
        log.info("扣减库存成功");
    }
}