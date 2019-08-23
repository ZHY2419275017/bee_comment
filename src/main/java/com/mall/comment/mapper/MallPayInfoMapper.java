package com.mall.comment.mapper;

import com.mall.comment.pojo.MallPayInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MallPayInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MallPayInfo record);

    MallPayInfo selectByPrimaryKey(Integer id);

    List<MallPayInfo> selectAll();

    int updateByPrimaryKey(MallPayInfo record);
}