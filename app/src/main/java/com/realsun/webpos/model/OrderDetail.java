package com.realsun.webpos.model;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

public class OrderDetail extends DataSupport{
	 @Column(nullable = false)
	    private String name;
		
	    private int amount;
		
	    
	    private PosOrder order;

	    private float price;

		 
		public void setName(String name) {
			this.name = name;
		}

		public int getAmount() {
			return amount;
		}

		public void setAmount(int amount) {
			this.amount = amount;
		}

		public PosOrder getOrder() {
			return order;
		}

		public void setOrder(PosOrder order) {
			this.order = order;
		}

		public float getPrice() {
			return price;
		}

		public void setPrice(float price) {
			this.price = price;
		}

}
