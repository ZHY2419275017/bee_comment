package com.mall.comment.mapper;

import com.mall.comment.pojo.MallCart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MallCartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MallCart record);

    MallCart selectByPrimaryKey(Integer id);

    List<MallCart> selectAll();

    int updateByPrimaryKey(MallCart record);
}