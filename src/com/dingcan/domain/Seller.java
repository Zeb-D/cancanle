package com.dingcan.domain;
/*
 * 商家
 * @parame:7 sellerid,sellername,pictureaddr,priceqisong
 * pricepeisong,telephone,totalsell
 */
public class Seller {
	public int sellerid;
	public String sellername;
	public String pictureaddr;
	public int priceqisong;
	public int pricepeisong;
	public int telephone;
	public int totalsell;
	/*
	 * 参数：sellerid,sellername,pictureaddr,priceqisong
	 * pricepeisong,telephone,totalsell
	 */
	@Override
	public String toString() {
		return "Seller [sellerid=" + sellerid + ", sellername=" + sellername
				+ ", pictureaddr=" + pictureaddr + ", priceqisong="
				+ priceqisong + ", pricepeisong=" + pricepeisong
				+ ", telephone=" + telephone + ", totalsell=" + totalsell + "]";
	}
	public Seller(int sellerid, String sellername, String pictureaddr,
			int priceqisong, int pricepeisong, int telephone, int totalsell) {
		super();
		this.sellerid = sellerid;
		this.sellername = sellername;
		this.pictureaddr = pictureaddr;
		this.priceqisong = priceqisong;
		this.pricepeisong = pricepeisong;
		this.telephone = telephone;
		this.totalsell = totalsell;
	}
	public int getSellerid() {
		return sellerid;
	}
	public void setSellerid(int sellerid) {
		this.sellerid = sellerid;
	}
	public String getSellername() {
		return sellername;
	}
	public void setSellername(String sellername) {
		this.sellername = sellername;
	}
	public String getPictureaddr() {
		return pictureaddr;
	}
	public void setPictureaddr(String pictureaddr) {
		this.pictureaddr = pictureaddr;
	}
	public int getPriceqisong() {
		return priceqisong;
	}
	public void setPriceqisong(int priceqisong) {
		this.priceqisong = priceqisong;
	}
	public int getPricepeisong() {
		return pricepeisong;
	}
	public void setPricepeisong(int pricepeisong) {
		this.pricepeisong = pricepeisong;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public int getTotalsell() {
		return totalsell;
	}
	public void setTotalsell(int totalsell) {
		this.totalsell = totalsell;
	}
	
}
