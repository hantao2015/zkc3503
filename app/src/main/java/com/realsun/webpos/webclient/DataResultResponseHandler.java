package com.realsun.webpos.webclient;

import org.apache.http.Header;
import org.json.JSONObject;

import com.loopj.android.http.JsonHttpResponseHandler;

public class DataResultResponseHandler extends JsonHttpResponseHandler{
	private WebDataNotifier m_wdn;
	public DataResultResponseHandler(WebDataNotifier wdn) {
		// TODO Auto-generated constructor stub
		this.m_wdn=wdn;
	}
	 
	 @Override
		public void onFailure(int statusCode, Header[] headers,
				String responseBody, Throwable e) {
			super.onFailure(statusCode, headers, responseBody, e);
			DataResult result=new DataResult();
			result.error=-1;
			result.message=responseBody;
			m_wdn.result(result);
		}
	  @Override
		public void onSuccess(int statusCode, Header[] headers,
				JSONObject response) {
			super.onSuccess(statusCode, headers, response);
			DataResult result=new DataResult();
			if (statusCode == 200) {
				// 获取用户id
			
			 
				try {
					 
					 
					
					String jsonString = response.toString();
				 
					result= com.alibaba.fastjson.JSON.parseObject(jsonString, DataResult.class);
					 
					m_wdn.result(result);
					 
					 
				} catch ( Exception e) {
				 
					result.error=-2;
					result.message=e.getMessage();
					m_wdn.result(result);
				}

			} else {
		
				result.error=statusCode;
				result.message="服务器异常";
				m_wdn.result(result);
			 
			}
		}

}
