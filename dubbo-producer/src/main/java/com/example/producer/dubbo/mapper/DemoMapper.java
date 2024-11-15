package com.example.producer.dubbo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * packageName com.example.producer.dubbo
 * @author remaindertime
 * @className DemoMapper
 * @date 2024/11/14
 * @description
 */
@Mapper
public interface DemoMapper {

    @Update("UPDATE xf_product SET num = num - #{num} WHERE id = #{productId}")
    void deInventory(@Param("num") Integer num, @Param("productId") Integer productId);

}
