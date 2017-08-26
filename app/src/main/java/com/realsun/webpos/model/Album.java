package com.realsun.webpos.model;

import java.util.ArrayList;
import java.util.List;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

public class Album extends DataSupport {
	
    @Column(unique = true, defaultValue = "unknown")
    private String name;
	
    private float price;
	
    private byte[] cover;
	
    private List<Song> songs = new ArrayList<Song>();

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	public void setName(String name) {
		this.name = name;
	}

   
}