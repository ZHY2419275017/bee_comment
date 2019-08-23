package com.mall.comment.mapper;

import com.mall.comment.pojo.MallOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MallOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MallOrder record);

    MallOrder selectByPrimaryKey(Integer id);

    List<MallOrder> selectAll();

    int updateByPrimaryKey(MallOrder record);
}