package com.realsun.utils;

 

import com.realsun.webpos.R;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class ConnectionChangeReceiver extends BroadcastReceiver {

	private static ConnectionChangeReceiver instence;
	private static final String UPLOAD_TESTDATA = "BleApplication.updateTestData";
	private static final String UPDATE_EQ_DATA = "updateEqData";
	public static WebClientConnection systemwcc=new WebClientConnection();
	public static boolean connectionFla = false; 
	public static boolean loginsystem=false;
	public static ConnectionChangeReceiver getInstence() {
		if (null == instence) {
			instence = new ConnectionChangeReceiver();
		}
		return instence;
	}
	 public void loginService(final Context context)
	    {
	    	CmsDatabase.InitialWebDbEnvironment();
			  
			  
			  WebClientConnectionPool.TryCreateWebClientConnection(CmsDatabase.m_syswdbc, new WebConnectionNotifier(){

				@Override
				public void result(WebClientConnection wcc) {
					// TODO Auto-generated method stub
					systemwcc=wcc;
					if (systemwcc.OpResult.equals("Y")){

						
				    	 Toast.makeText(context,R.string.loginsuccess,Toast.LENGTH_LONG).show();

				    	 loginsystem=true;
				    	
				    }
				    else
				    {
				    	 Toast.makeText(context,R.string.loginfailed+systemwcc.ErrorMsg,Toast.LENGTH_LONG).show();
				    	 loginsystem=false;
				    }
				
				}});
	    }
	 public void logoutService(Context context)
	    {
		    systemwcc=new WebClientConnection();
		    loginsystem=false;
	    }
	    
	

	@Override
	public void onReceive(Context context, Intent intent) {
		ConnectivityManager connectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();

		if (activeNetInfo != null && activeNetInfo.isAvailable()) {
		 
			connectionFla = true;
			loginService(context);
			
			 
 
		} else {
			logoutService(context);
	        
			connectionFla = false;
			Toast.makeText(context,
					context.getResources().getString(R.string.netwrok_tishi),
					Toast.LENGTH_LONG).show();
			 
		}

	}
}