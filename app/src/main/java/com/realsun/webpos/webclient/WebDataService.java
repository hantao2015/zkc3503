package com.realsun.webpos.webclient;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;
import com.realsun.utils.JsonUtil;
import com.realsun.utils.NetRestClient;
import com.realsun.utils.WebClientConnection;
import com.realsun.utils.WebDbConfig;

public class WebDataService {
	public void save(SaveDataTableParm parms,WebClientConnection wcc,final WebDataNotifier wdn) { 
		 StringEntity  stringEntity = null;
		 try { 
		       
			  parms.setData();
			  String jsonStr=JSON.toJSONString(parms);
			  
			  stringEntity = new StringEntity(jsonStr,HTTP.UTF_8); 
			  
			  } catch (Exception e1) { 
			     e1.printStackTrace(); 
			  } 
		 String url=WebDbConfig.m_BASE_URL+WebDbConfig.m_saveMethod;
		 NetRestClient.Post(url, stringEntity,wcc, new DataResultResponseHandler(wdn));
		
		
	}
	
	public   void retrieve(GetDatatableParm parms,WebClientConnection wcc,final WebDataNotifier wdn){
		 
	 
		if (parms.resid.equalsIgnoreCase(""))
		{
			DataResult result=new DataResult();
			result.message="resid is null";
			wdn.result(result);
			return;
		}
		RequestParams params= new RequestParams();
		String url=WebDbConfig.m_BASE_URL+WebDbConfig.m_retrieveMethod+parms.getUrlParm();
 
		NetRestClient.get(url,wcc, new DataResultResponseHandler(wdn));
	 
		
		 
		
		 
	}
	

}
