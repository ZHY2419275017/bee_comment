package com.mall.comment;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mall.comment.mapper.MallCommentMapper;
import com.mall.comment.pojo.MallComment;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallCommentApplicationTests {
	
   @Autowired
   private MallCommentMapper commentMapper;
	
   @Test
   public void addcomment(){
	  MallComment comment = new MallComment(); 
	  comment.setComUserId(2);
	  comment.setComProId(26);
	  comment.setComTitle("还行");
	  comment.setComContent("很满意啦，质量不错，下次还来买");
	  comment.setComTime(new Date());
	  comment.setComScore(4);	  
	  Integer result = commentMapper.insert(comment);
	  System.out.println(result);
	  //测试成功
   }

}
