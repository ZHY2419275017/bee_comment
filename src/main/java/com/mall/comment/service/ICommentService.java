package com.mall.comment.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.mall.comment.pojo.MallComment;
import com.mall.comment.vo.CommentVo;

public interface ICommentService {
	//增加评价内容
	public String addComment(MallComment mallComment);	
	//按用户id和商品id联合查询评价内容
	public CommentVo findCommentId(Integer comUserId,Integer comProId);
	//根据用户id查找评论(带分页查找)
	public PageInfo findCommentByUserId(Integer comUserId,Integer pageNum,Integer pageSize);
	//根据评论id删除评论
	public String deleteCommentById(Integer id);
	
	

}
