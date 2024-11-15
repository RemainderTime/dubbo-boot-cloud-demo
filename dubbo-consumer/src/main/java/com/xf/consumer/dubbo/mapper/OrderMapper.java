package com.xf.consumer.dubbo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * packageName com.xf.consumer.dubbo
 * @author remaindertime
 * @className OrderMapper
 * @date 2024/11/14
 * @description
 */
@Mapper
public interface OrderMapper {

    @Insert("INSERT INTO xf_order (user_id, product_id) values (#{userId}, #{productId})")
    void createOrder(@Param("userId") Integer userId,@Param("productId") Integer productId);
}
