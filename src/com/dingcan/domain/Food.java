package com.dingcan.domain;
/*
 * 菜谱
 * @parame
 */
public class Food {
	public int foodid;
	public String foodname;
	public int sellerid;
	public double price;
	public String picture;
	public int rest;
	public int totalsell;
	public double stars;
	/*
	 * 参数: foodid foodname,sellerid,price,picetureaddress,rest,totalsell
	 * stars
	 */
	public Food(int foodid, String foodname, int sellerid, double price,
			String picture, int rest, int totalsell, double stars) {
		super();
		this.foodid = foodid;
		this.foodname = foodname;
		this.sellerid = sellerid;
		this.price = price;
		this.picture = picture;
		this.rest = rest;
		this.totalsell = totalsell;
		this.stars = stars;
	}
	public int getFoodid() {
		return foodid;
	}
	public void setFoodid(int foodid) {
		this.foodid = foodid;
	}
	public String getFoodname() {
		return foodname;
	}
	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	public int getSellerid() {
		return sellerid;
	}
	public void setSellerid(int sellerid) {
		this.sellerid = sellerid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getRest() {
		return rest;
	}
	public void setRest(int rest) {
		this.rest = rest;
	}
	public int getTotalsell() {
		return totalsell;
	}
	public void setTotalsell(int totalsell) {
		this.totalsell = totalsell;
	}
	public double getStars() {
		return stars;
	}
	public void setStars(double stars) {
		this.stars = stars;
	}
	
}
