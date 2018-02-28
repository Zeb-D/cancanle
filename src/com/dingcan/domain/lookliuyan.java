package com.dingcan.domain;

import java.util.Date;

/*
 * Notice:只显示lookliuyan_view
 */
public class lookliuyan {
	public int id;
	public String username;
	public String foodname;
	public String comment;
	public String reply;
	public int stars;
	public Date date;

	@Override
	public String toString() {
		return "lookliuyan [id=" + id + ", username=" + username
				+ ", foodname=" + foodname + ", comment=" + comment
				+ ", reply=" + reply + ", stars=" + stars + ", date=" + date
				+ "]";
	}

	public lookliuyan(int id, String username, String foodname, String comment,
			String reply, int stars, Date date) {
		super();
		this.id = id;
		this.username = username;
		this.foodname = foodname;
		this.comment = comment;
		this.reply = reply;
		this.stars = stars;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
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

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
