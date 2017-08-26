package com.realsun.utils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BufferedHeader;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.BinaryHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;
import com.loopj.android.http.SyncHttpClient;
 
public class NetRestClient {
	public static final String BASE_URL = "http://kingofdinner.realsun.me:9091/";
	public static AsyncHttpClient client = new AsyncHttpClient();
	public static SyncHttpClient  synclient = new SyncHttpClient();
	public static String loginMethod ="api/Account/Login";
	public static String login_error_code = "11201";
	static {
		client.setTimeout(1000 * 10);
	}
	public static void get(String url, RequestParams params,
			AsyncHttpResponseHandler responseHandler) {
		if (ConnectionChangeReceiver.connectionFla) {
			client.get(getAbsoluteUrl(url), params, responseHandler);
		}

	}
	 
	public static void get(String url,WebClientConnection wcc,
			JsonHttpResponseHandler responseHandler) {
		if (ConnectionChangeReceiver.connectionFla) {
			Context context = null;

		   RequestParams params=new RequestParams();
		   client.get(  context,url,wcc.getHeaders(),params,responseHandler);
		}

	}
	public static void Post(String url, StringEntity parms,WebClientConnection wcc,
			AsyncHttpResponseHandler responseHandler) {
		
	
		
		if (ConnectionChangeReceiver.connectionFla) {
			 
			Context context = null;
		 
			client.post(context, url, wcc.getHeaders(), parms, "application/json", responseHandler);
		}
	}
	public static void postBySyn(String url,  StringEntity parms,JsonHttpResponseHandler responseHandler) {
		
	
		
		if (ConnectionChangeReceiver.connectionFla) {
			System.out.println("进行提交操作");
			Context context = null;
			synclient.post(context, url, parms, "application/json", (ResponseHandlerInterface) responseHandler);
		}
	}
	public static void post(String url, RequestParams params,
			AsyncHttpResponseHandler responseHandler) {
		
	
		
		if (ConnectionChangeReceiver.connectionFla) {
			System.out.println("进行提交操作");
			client.post(getAbsoluteUrl(url), params, responseHandler);
		}
	}
	public static void post(String url, StringEntity parms,
			AsyncHttpResponseHandler responseHandler) {
		
	
		
		if (ConnectionChangeReceiver.connectionFla) {
			System.out.println("进行提交操作");
			Context context = null;
			client.post(context, getAbsoluteUrl(url), parms, "application/json", responseHandler);
		}
	}
	public static void AsynPost(String url, StringEntity parms,
			AsyncHttpResponseHandler responseHandler) {
		
	
		
		if (ConnectionChangeReceiver.connectionFla) {
			 
			Context context = null;
			client.post(context, url, parms, "application/json", responseHandler);
		}
	}
	private static String getAbsoluteUrl(String relativeUrl) {
		return BASE_URL + relativeUrl;
	}


}
