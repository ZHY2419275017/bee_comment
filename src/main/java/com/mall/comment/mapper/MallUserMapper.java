package com.mall.comment.mapper;

import com.mall.comment.pojo.MallUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MallUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MallUser record);

    MallUser selectByPrimaryKey(Integer id);

    List<MallUser> selectAll();

    int updateByPrimaryKey(MallUser record);
}