package com.mall.comment.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.comment.mapper.MallCommentMapper;
import com.mall.comment.mapper.MallProductMapper;
import com.mall.comment.pojo.MallComment;
import com.mall.comment.pojo.MallProduct;
import com.mall.comment.service.ICommentService;
import com.mall.comment.vo.CommentVo;

@Service
public class CommentServiceImpl implements ICommentService {
	
	@Autowired
	private MallCommentMapper commentMapper;
	@Autowired
	private MallProductMapper productMapper;

	@Override
	public String addComment(MallComment mallComment) {
		if(null!=mallComment){			
			try {
				commentMapper.insert(mallComment);
			} catch (Exception e) {
				return "error";
			}
			return "success";
		}else{
			return "error";
		}		
	}

	@Override
	public CommentVo findCommentId(Integer comUserId, Integer comProId) {		
		MallComment comment =  commentMapper.selectByUserIdProId(comUserId, comProId);
		MallProduct product = productMapper.selectByPrimaryKey(comment.getComProId());
		CommentVo commentVo = new CommentVo();
		commentVo.setId(comment.getId());
		commentVo.setComUserId(comment.getComUserId());
		commentVo.setName(product.getName());
		commentVo.setSubtitle(product.getSubtitle());
		commentVo.setMainImage(product.getMainImage());
		commentVo.setComTitle(comment.getComTitle());
		commentVo.setComContent(comment.getComContent());
		commentVo.setComTime(comment.getComTime());
		commentVo.setComScore(comment.getComScore());
		return commentVo;
   
	}

	@Override
	public PageInfo findCommentByUserId(Integer comUserId,Integer pageNum,Integer pageSize) {
		//带分页
		List<CommentVo> commentVoList  = new ArrayList<CommentVo>();
		PageHelper.startPage(pageNum,pageSize);			
		List<MallComment> comments = commentMapper.findCommentByUserId(comUserId);	
		for(MallComment comment : comments){
			MallProduct product = productMapper.selectByPrimaryKey(comment.getComProId());
			CommentVo commentVo = new CommentVo();
			commentVo.setId(comment.getId());
			commentVo.setComUserId(comment.getComUserId());
			commentVo.setName(product.getName());
			commentVo.setSubtitle(product.getSubtitle());
			commentVo.setMainImage(product.getMainImage());
			commentVo.setComTitle(comment.getComTitle());
			commentVo.setComContent(comment.getComContent());
			commentVo.setComTime(comment.getComTime());
			commentVo.setComScore(comment.getComScore());
			commentVoList.add(commentVo);
		}	
		PageInfo pageResult = new PageInfo(comments);
		pageResult.setList(commentVoList);
		return pageResult;
	}

	@Override
	public String deleteCommentById(Integer id) {
		int result = commentMapper.deleteByPrimaryKey(id);	
		return (result>0?"success":"error");
	}
	
	
	

}
