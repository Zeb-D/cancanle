package com.dingcan.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Liuyan {
	public int id;
	public int userid;
	public int foodid;
	public Date commentdate;
	public int stars;
	public String comment;
	public String reply;
	
	
	public Liuyan(int id, int userid, int foodid, Date comment_date, int stars,
			String comment, String reply) {
		super();
		this.id = id;
		this.userid = userid;
		this.foodid = foodid;
		this.commentdate = comment_date;
		this.stars = stars;
		this.comment = comment;
		this.reply = reply;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getFoodid() {
		return foodid;
	}
	public void setFoodid(int foodid) {
		this.foodid = foodid;
	}
	
	public Date getCommentdate() {
		return commentdate;
	}
	public void setCommentdate(Date commentdate) {
		this.commentdate = commentdate;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getReply() {
		return reply;
	}
	
	public void setReply(String reply) {
		this.reply = reply;
	}
	
}
