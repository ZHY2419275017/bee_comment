package com.mall.comment.mapper;

import com.mall.comment.pojo.MallAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MallAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MallAddress record);

    MallAddress selectByPrimaryKey(Integer id);

    List<MallAddress> selectAll();

    int updateByPrimaryKey(MallAddress record);
}