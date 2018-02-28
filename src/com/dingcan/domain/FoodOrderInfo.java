package com.dingcan.domain;

import java.math.BigDecimal;
import java.util.Date;

public class FoodOrderInfo {
	private int id;
	private int userid;
	private int foodid;
	private int foodid2;
	private String address;
	private BigDecimal telephone;
	private String notice;
	private double totalprice;
	private int foodamount;
	private Date bookdate;
	private String state;
	
	public FoodOrderInfo(int id, int userid, int foodid, int foodid2,
			String address, BigDecimal telephone, String notice, double totalprice,
			int foodamount, Date bookdate, String state) {
		super();
		this.id = id;
		this.userid = userid;
		this.foodid = foodid;
		this.foodid2 = foodid2;
		this.address = address;
		this.telephone = telephone;
		this.notice = notice;
		this.totalprice = totalprice;
		this.foodamount = foodamount;
		this.bookdate = bookdate;
		this.state = state;
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
	public int getFoodid2() {
		return foodid2;
	}
	public void setFoodid2(int foodid2) {
		this.foodid2 = foodid2;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public BigDecimal getTelephone() {
		return telephone;
	}
	public void setTelephone(BigDecimal telephone) {
		this.telephone = telephone;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public int getFoodamount() {
		return foodamount;
	}
	public void setFoodamount(int foodamount) {
		this.foodamount = foodamount;
	}
	public Date getBookdate() {
		return bookdate;
	}
	public void setBookdate(Date bookdate) {
		this.bookdate = bookdate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	
}
