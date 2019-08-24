package com.mall.comment.controller;



import com.github.pagehelper.PageInfo;
import com.mall.comment.pojo.MallComment;
import com.mall.comment.service.ICommentService;
import com.mall.comment.vo.CommentVo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequestMapping(value="/comment")
public class CommentController {
   
	@Autowired
	private ICommentService commentService;
    /**
     * 新增评价
     * @param mallComment
     * @return 成功返回 "success" 失败返回"error"
     */
    @PostMapping(value="/addComment")
    public String addComment(MallComment mallComment){   	
    	return commentService.addComment(mallComment);   
    }  
    /**
     * 根据用户id和商品id查找评论
     * @param comUserId
     * @param comProId
     * @return CommentVo
     */
    @GetMapping(value="/findComment")
    public CommentVo findComment(@RequestParam("comUserId") Integer comUserId,@RequestParam("comProId") Integer comProId){
    	return commentService.findCommentId(comUserId, comProId);
    }
    /**
     * 根据用户id查找属于该用户的评价(带分页)
     * @param comUserId
     * @return CommenVo
     */
    @GetMapping(value="/findCommentByUserId")
    public PageInfo findCommentByUserId(Integer comUserId,Integer pageNum,Integer pageSize){
		return commentService.findCommentByUserId(comUserId, pageNum, pageSize);   	
    }
    
    /**
     * 根评论id删除评论
     * @param id
     * @return 成功"success" 失败："error"
     */
    @DeleteMapping(value="/delete")
    public String delete(Integer id){
        return commentService.deleteCommentById(id);
    }
    
    /**
     * 根据商品id查询评价
     * @param productId
     * @return
     */
    @GetMapping(value="/findCommentByProductId")
    public List<CommentVo> findCommentByProductId(Integer productId){
    	return commentService.findCommentByProductId(productId);
    }
    
   
    
    
    

}
