package com.mall.comment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.mall.comment.service.ICommentService;

@RestController
@Controller
@RequestMapping(value="/adminComment")
public class CommentManageController {
	
	@Autowired
	private ICommentService commentService;
	
	private Logger logger =LoggerFactory.getLogger(CommentManageController.class);
	
	 /**
     * 查询所有的评论
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value="/selectAll")
    public PageInfo selectAllComment(@RequestParam(value="pageNum",defaultValue="1") Integer pageNum,
    		                         @RequestParam(value="pageSize",defaultValue="3")Integer pageSize){
    	logger.info("评论模块管理员selectAll被执行");
    	return commentService.selectAllComment(pageNum, pageSize);
    }
    
    @GetMapping(value="/delete")
    public PageInfo delete(@RequestParam("id") Integer id,
			    		@RequestParam(value="pageNum",defaultValue="1") Integer pageNum,
			            @RequestParam(value="pageSize",defaultValue="3")Integer pageSize){
    	logger.info("评论模块管理员delete被执行");
    	commentService.deleteCommentById(id);
    	return commentService.selectAllComment(pageNum, pageSize);   	
    }
    

}
