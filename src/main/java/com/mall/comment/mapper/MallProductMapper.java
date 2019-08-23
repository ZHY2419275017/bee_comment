package com.mall.comment.mapper;

import com.mall.comment.pojo.MallProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MallProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MallProduct record);

    MallProduct selectByPrimaryKey(Integer id);

    List<MallProduct> selectAll();

    int updateByPrimaryKey(MallProduct record);
}