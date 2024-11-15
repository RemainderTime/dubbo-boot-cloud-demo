package com.xf.api;

/**
 * packageName com.xf.api
 * @author remaindertime
 * @className DemoService
 * @date 2024/11/12
 * @description
 */
public interface DemoService {

    String sayHello(String name);

    /**
     * 扣减库存
     * @param num
     */
    void deInventory(Integer num, Integer productId);

}
