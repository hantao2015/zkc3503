package com.realsun.webpos.webclient;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class SaveDataTableParm {
	
	 	public String uniquecolumns="";
	 	public String withoutdata;
	    public String formulalayer="1";
	    public String synchronizedat="1";
	    public String resid="" ;
	    public String data="" ;
	    public List dataoflist=new ArrayList();
	    public void setData()
	    {
	    	this.data=JSON.toJSONString(dataoflist);
	    }
}
