package com.dingcan.domain;

/*
 * 用户信息
 */
public class UserInfo {
	public int userid;
	public String username;
	public String userpass;
	public String address;
	public String address2; // 地址2
	public double money;

	/*
	 * 参数： userid,username,userpass,address,address2,money
	 */
	public UserInfo(int userid, String username, String userpass,
			String address, String address2, double money) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpass = userpass;
		this.address = address;
		this.address2 = address2;
		this.money = money;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "UserInfo [userid=" + userid + ", username=" + username
				+ ", userpass=" + userpass + ", address=" + address
				+ ", address2=" + address2 + ", money=" + money + "]";
	}

}
