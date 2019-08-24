package com.mall.comment.vo;

import java.util.Date;

public class CommentVo {
	
	    private Integer id;

	    private String username;//用户名
	    
	    private String name;//商品名称

	    private String subtitle;//商品标题

	    private String mainImage;//商品主图

	   // private Integer comProId;

	    private String comTitle;//评论标题

	    private String comContent;//评论内容

	    private Date comTime;//评论时间

	    private Integer comScore;//评论分数

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSubtitle() {
			return subtitle;
		}

		public void setSubtitle(String subtitle) {
			this.subtitle = subtitle;
		}

		public String getMainImage() {
			return mainImage;
		}

		public void setMainImage(String mainImage) {
			this.mainImage = mainImage;
		}

		public String getComTitle() {
			return comTitle;
		}

		public void setComTitle(String comTitle) {
			this.comTitle = comTitle;
		}

		public String getComContent() {
			return comContent;
		}

		public void setComContent(String comContent) {
			this.comContent = comContent;
		}

		public Date getComTime() {
			return comTime;
		}

		public void setComTime(Date comTime) {
			this.comTime = comTime;
		}

		public Integer getComScore() {
			return comScore;
		}

		public void setComScore(Integer comScore) {
			this.comScore = comScore;
		}

		public CommentVo(Integer id, String username, String name, String subtitle, String mainImage, String comTitle,
				String comContent, Date comTime, Integer comScore) {
			super();
			this.id = id;
			this.username = username;
			this.name = name;
			this.subtitle = subtitle;
			this.mainImage = mainImage;
			this.comTitle = comTitle;
			this.comContent = comContent;
			this.comTime = comTime;
			this.comScore = comScore;
		}

		public CommentVo() {
			super();
		}
	    
	    

		
}
