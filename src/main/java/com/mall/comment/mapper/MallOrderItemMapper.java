package com.mall.comment.mapper;

import com.mall.comment.pojo.MallOrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MallOrderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MallOrderItem record);

    MallOrderItem selectByPrimaryKey(Integer id);

    List<MallOrderItem> selectAll();

    int updateByPrimaryKey(MallOrderItem record);
}