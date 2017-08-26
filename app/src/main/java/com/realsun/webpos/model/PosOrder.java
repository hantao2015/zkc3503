package com.realsun.webpos.model;

import java.util.ArrayList;
import java.util.List;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

public class PosOrder extends DataSupport{
	 
	 
    private String name;
	 
    private String badgeno;
 
    private String cardno;
    @Column(unique = true,nullable = false)
	private String orderno;
  
    private int  dishtypeno;
   
    private String dates;
    private String ispaid; 
    private String iscancle;  
    private float price;
    
    private List<OrderDetail> menus = new ArrayList<OrderDetail>();
	public void setName(String name) {
		this.name = name;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getBadgeno() {
		return badgeno;
	}

	public void setBadgeno(String badgeno) {
		this.badgeno = badgeno;
	}

	public int getDishtypeno() {
		return dishtypeno;
	}

	public void setDishtypeno(int dishtypeno) {
		this.dishtypeno = dishtypeno;
	}

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public String getIspaid() {
		return ispaid;
	}

	public void setIspaid(String ispaid) {
		this.ispaid = ispaid;
	}

	public String getIscancle() {
		return iscancle;
	}

	public void setIscancle(String iscancle) {
		this.iscancle = iscancle;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public List<OrderDetail> getMenus() {
		return menus;
	}

	public void setMenus(List<OrderDetail> menus) {
		this.menus = menus;
	}
 

}
