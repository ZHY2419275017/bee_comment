package com.mall.comment.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.comment.mapper.MallCommentMapper;
import com.mall.comment.mapper.MallProductMapper;
import com.mall.comment.mapper.MallUserMapper;
import com.mall.comment.pojo.MallComment;
import com.mall.comment.pojo.MallProduct;
import com.mall.comment.pojo.MallUser;
import com.mall.comment.service.ICommentService;
import com.mall.comment.service.ProductService;
import com.mall.comment.vo.CommentVo;

@Service
public class CommentServiceImpl implements ICommentService {
	
	@Autowired
	private MallCommentMapper commentMapper;
	@Autowired
	private MallProductMapper productMapper;
	@Autowired
	private MallUserMapper userMapper;
	
	private Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);

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
		if(comment==null){
			return null;
		}
		MallProduct product = productMapper.selectByPrimaryKey(comment.getComProId());
		CommentVo commentVo = new CommentVo();
		commentVo.setId(comment.getId());
		MallUser user = userMapper.selectByPrimaryKey(comment.getComUserId());
		commentVo.setUsername(user.getUsername());
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
			MallUser user = userMapper.selectByPrimaryKey(comment.getComUserId());
			if(user==null){
				logger.error("评价部分根据用户id查找用户未找到");
				return null;
			}
			commentVo.setUsername(user.getUsername());
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

	@Override
	public PageInfo selectAllComment(Integer pageNum,Integer pageSize) {
		//带分页
		List<CommentVo> commentVoList  = new ArrayList<CommentVo>();
		PageHelper.startPage(pageNum,pageSize);			
		List<MallComment> comments = commentMapper.selectAll();	
		
		for(MallComment comment : comments){
			MallProduct product = productMapper.selectByPrimaryKey(comment.getComProId());
			
			/*ProductService productService = new ProductService();
			MallProduct product = productService.selectProductById(comment.getComProId());*/
			
			CommentVo commentVo = new CommentVo();
			commentVo.setId(comment.getId());			
			MallUser user = userMapper.selectByPrimaryKey(comment.getComUserId());
			if(user==null){
				logger.error("评价部分根据用户id查找用户未找到");
				return null;
			}
			commentVo.setUsername(user.getUsername());
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
	public List<CommentVo> findCommentByProductId(Integer productId) {
		List<CommentVo> commentVoList  = new ArrayList<CommentVo>();
	    List<MallComment> comments = commentMapper.findCommentByProductId(productId);
	    for(MallComment comment : comments){
			MallProduct product = productMapper.selectByPrimaryKey(comment.getComProId());
			
			/*ProductService productService = new ProductService();
			MallProduct product = productService.selectProductById(comment.getComProId());*/
			
			CommentVo commentVo = new CommentVo();
			commentVo.setId(comment.getId());
			
			MallUser user = userMapper.selectByPrimaryKey(comment.getComUserId());
			if(user==null){
				logger.error("评价部分根据用户id查找用户未找到");
				return null;
			}
			commentVo.setUsername(user.getUsername());		
			commentVo.setName(product.getName());
			commentVo.setSubtitle(product.getSubtitle());
			commentVo.setMainImage(product.getMainImage());
			commentVo.setComTitle(comment.getComTitle());
			commentVo.setComContent(comment.getComContent());
			commentVo.setComTime(comment.getComTime());
			commentVo.setComScore(comment.getComScore());
			commentVoList.add(commentVo);
		}	
		return commentVoList;
	}
	
	
	
	

}
