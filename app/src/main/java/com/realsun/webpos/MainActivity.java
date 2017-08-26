package com.realsun.webpos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.entity.StringEntity;
import org.apache.http.Header;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.realsun.utils.CmsDatabase;
import com.realsun.utils.ConnectionChangeReceiver;
import com.realsun.utils.NetRestClient;
import com.realsun.utils.WebClientConnection;
import com.realsun.utils.WebClientConnectionPool;
import com.realsun.utils.WebConnectionNotifier;
import com.realsun.utils.WebDbConfig;

import com.realsun.webpos.model.*;
import com.realsun.webpos.webclient.DataResult;
import com.realsun.webpos.webclient.GetDatatableParm;
import com.realsun.webpos.webclient.SaveDataTableParm;
import com.realsun.webpos.webclient.WebDataNotifier;
import com.realsun.webpos.webclient.WebDataService;

import com.smartdevice.printer.PrinterHelper;
import com.smartdevice.printer.entity.SupermakerBill;


import org.json.JSONException;
import org.json.JSONObject;
import org.litepal.LitePal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.NfcA;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemLongClickListener;

public class MainActivity extends BaseActivity implements OnClickListener {
	private NfcAdapter nfcAdapter;
	Button  loginButton,downloadButton;
	private TextView promt;
	private byte password[] = { (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff,
			(byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff,
			(byte) 0xff, (byte) 0xff, (byte) 0xff };
	public List<Nfc> list;
	private ListView listView;
	private Intent intents;
	int imageType=0;
	private boolean isnews = true;
	private PendingIntent pendingIntent;
	private IntentFilter[] mFilters;
	private String[][] mTechLists;
	private Nfc mynfc;
	private String dataString;
	private ProgressDialog prodialog ;

	public ConnectionChangeReceiver mConnectivityReceiver = ConnectionChangeReceiver
			.getInstence();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		loginButton=(Button)findViewById(R.id.login);
		downloadButton=(Button)findViewById(R.id.download);
		listView = (ListView) findViewById(R.id.listView1);
		promt = (TextView) findViewById(R.id.promt);
		// 获取默认的NFC控制器
		nfcAdapter = NfcAdapter.getDefaultAdapter(this);

		if (nfcAdapter == null) {
			promt.setText("Device can not support NFC！");
			finish();
			return;
		}
		if (!nfcAdapter.isEnabled()) {
			promt.setText("Please open NFC in system setting！");
			finish();
			return;
		}

		pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this,
				getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
		IntentFilter ndef = new IntentFilter(NfcAdapter.ACTION_TECH_DISCOVERED);
		ndef.addCategory("*/*");
		mFilters = new IntentFilter[] { ndef };// 过滤器
		mTechLists = new String[][] {
				new String[] { MifareClassic.class.getName() },
				new String[] { NfcA.class.getName() } };// 允许扫描的标签类型
		//设置连接状态接收器
		mConnectivityReceiver = ConnectionChangeReceiver.getInstence();
		IntentFilter filter = new IntentFilter();
		filter.addAction(android.net.ConnectivityManager.CONNECTIVITY_ACTION);
		registerReceiver(mConnectivityReceiver, filter);
		// 保持屏幕一直亮
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
				WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		//设置按钮事件
		initListener();

	}
	@Override
	protected void onResume() {
		super.onResume();
		// 得到是否检测到ACTION_TECH_DISCOVERED触发
		nfcAdapter.enableForegroundDispatch(this, pendingIntent, mFilters,
				mTechLists);
		if (isnews) {
			if (NfcAdapter.ACTION_TECH_DISCOVERED.equals(getIntent()
					.getAction())) {
				// 处理该intent
				processIntent(getIntent());
				intents = getIntent();
				isnews = false;
			}
		}
	}
	// 字符序列转换为16进制字符串
	private String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		char[] buffer = new char[2];
		for (int i = 0; i < src.length; i++) {
			buffer[0] = Character.forDigit((src[i] >>> 4) & 0x0F, 16);
			buffer[1] = Character.forDigit(src[i] & 0x0F, 16);

			stringBuilder.append(buffer);

		}
		return stringBuilder.toString();
	}

	private String bytesToHexString2(byte[] src) {

		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		char[] buffer = new char[2];
		for (int i = 0; i < src.length; i++) {
			buffer[0] = Character.forDigit((src[i] >>> 4) & 0x0F, 16);
			buffer[1] = Character.forDigit(src[i] & 0x0F, 16);

			stringBuilder.append(buffer);
			stringBuilder.append(" ");
		}
		return stringBuilder.toString();
	}
	@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		super.onNewIntent(intent);
		// 得到是否检测到ACTION_TECH_DISCOVERED触发
		// nfcAdapter.enableForegroundDispatch(this, pendingIntent, mFilters,
		// mTechLists);
		if (NfcAdapter.ACTION_TECH_DISCOVERED.equals(intent.getAction())) {
			// 处理该intent
			processIntent(intent);
			intents = intent;
		}

	}
	class ListLongClick implements OnItemLongClickListener {

		@Override
		public boolean onItemLongClick(AdapterView<?> parent, View view,
									   int position, long id) {
			// TODO Auto-generated method stub
			mynfc = list.get(position);
			if (mynfc.type == 1) {
				LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
				View nfcwrite = inflater.inflate(R.layout.nfcwrite, null);
				final EditText data = (EditText) nfcwrite
						.findViewById(R.id.et_nfcdata);
				AlertDialog.Builder builder = new Builder(MainActivity.this);
				builder.setView(nfcwrite);
				builder.setTitle("Write to tag");
				builder.setPositiveButton("Write",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
												int which) {
								// TODO Auto-generated method stub

								dataString = data.getText().toString().trim();
								Tag tagFromIntent = intents
										.getParcelableExtra(NfcAdapter.EXTRA_TAG);
								MifareClassic mfc = MifareClassic
										.get(tagFromIntent);
								boolean auth = false;
								short sectorAddress = (short) mynfc
										.getSectorId();
								try {
									mfc.connect();

									auth = mfc.authenticateSectorWithKeyA(
											sectorAddress,
											MifareClassic.KEY_DEFAULT);
									// 必须为16字节不够自己补0
									byte[] d = dataString.getBytes();
									byte[] f = new byte[16];
									for (int j = 0; j < d.length; j++) {
										f[j] = d[j];
									}
									if (d.length < 16) {
										int j = 16 - d.length;
										int k = d.length;
										for (int j2 = 0; j2 < j; j2++) {
											f[k + j2] = (byte) 0x00;
										}
									}
									if (auth) {
										// 写入数据
										mfc.writeBlock(mynfc.getId(), f);
										mfc.close();
										Toast.makeText(MainActivity.this,
												"Success", Toast.LENGTH_SHORT)
												.show();
										processIntent(getIntent());
									}
								} catch (IOException e) {
									Toast.makeText(MainActivity.this, "Please put the tags on the equipment behind",
											3000).show();
									// TODO Auto-generated catch block
									e.printStackTrace();
								} finally {
									try {
										mfc.close();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}
						}).setNegativeButton("Cancel", null);

				Dialog dialog = builder.create();
				dialog.show();
			}

			return false;
		}

	}

	/**
	 * 读取NFC信息数据
	 *
	 * @param intent
	 */
	private void processIntent(Intent intent) {
		boolean auth = false;
		String cardStr="";
		Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
		cardStr="ID："+bytesToHexString(tag.getId());
		String[] techList = tag.getTechList();
		boolean haveMifareUltralight = false;
		cardStr+="\r\nTECH：";
		for (String tech : techList) {
			cardStr+=tech+",";
			if (tech.indexOf("MifareClassic") >= 0) {
				haveMifareUltralight = true;
				break;
			}
		}
		if (!haveMifareUltralight) {
			promt.setText(cardStr);
			Toast.makeText(this, "this card type is not MifareClassic", Toast.LENGTH_LONG).show();
			return;
		}

		MifareClassic mfc = MifareClassic.get(tag);

		try {
			String metaInfo = "";
			// Enable I/O operations to the tag from this TagTechnology object.
			mfc.connect();
			int type = mfc.getType();// 获取TAG的类型
			int sectorCount = mfc.getSectorCount();// 获取TAG中包含的扇区数
			String typeS = "";
			switch (type) {
				case MifareClassic.TYPE_CLASSIC:
					typeS = "TYPE_CLASSIC";
					break;
				case MifareClassic.TYPE_PLUS:
					typeS = "TYPE_PLUS";
					break;
				case MifareClassic.TYPE_PRO:
					typeS = "TYPE_PRO";
					break;
				case MifareClassic.TYPE_UNKNOWN:
					typeS = "TYPE_UNKNOWN";
					break;
			}
			byte[] myNFCID = intent.getByteArrayExtra(NfcAdapter.EXTRA_ID);

			int before = (int) Long.parseLong(bytesToHexString(myNFCID), 16);

			int r24 = before >> 24 & 0x000000FF;
			int r8 = before >> 8 & 0x0000FF00;
			int l8 = before << 8 & 0x00FF0000;
			int l24 = before << 24 & 0xFF000000;

			metaInfo += "ID(dec):"
					+ Long.parseLong(
					Integer.toHexString((r24 | r8 | l8 | l24)), 16)
					+ "\nID(hex):" + bytesToHexString2(myNFCID) + "\nType："
					+ typeS + "\nSector：" + sectorCount + "\n Block："
					+ mfc.getBlockCount() + "\nSize： " + mfc.getSize() + "B";
			if (list == null) {
				list = new ArrayList<Nfc>();
			} else {
				list.clear();
			}


//			for (int j = 0; j < sectorCount; j++) {
//				auth = mfc.authenticateSectorWithKeyA(j,password);
//
//				int bCount;
//				int bIndex;
//				if (auth) {
//					list.add(new Nfc(j, 0, "Sector " + j + ": Authentication ok", j));
//
//					// 读取扇区中的块
//					bCount = mfc.getBlockCountInSector(j);
//					bIndex = mfc.sectorToBlock(j);
//					for (int i = 0; i < bCount; i++) {
//						byte[] data = mfc.readBlock(bIndex);
//
//						list.add(new Nfc(bIndex, 1, "Block " + bIndex + " : "
//								+ bytesToHexString(data), j));
//						bIndex++;
//					}
//				} else {
//
//					list.add(new Nfc(j, 0, "Sector " + j + ": Authentication Failed", j));
//				}
//			}
			SupermakerBill bill = PrinterHelper.getInstance(this).getSupermakerBill(mIzkcService, false, false);
			PrinterHelper.getInstance(this).printPurchaseBillModelOne(mIzkcService,bill, imageType);
			promt.setText(metaInfo);
			NfcsAdapter adapter = new NfcsAdapter(list, getApplicationContext());

			listView.setAdapter(adapter);
			listView.setOnItemLongClickListener(new ListLongClick());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (mfc != null) {
					mfc.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
			case R.id.login: {



				if (mConnectivityReceiver.getInstence().loginsystem )
				{
//				testofsqlit();
//				testofwebdata();

				}
				break;
			}


			case R.id.download:{
				//testprogress();
				prodialog= new ProgressDialog(MainActivity.this);
				testprogress();
				prePareDownloadData( );
				break;

			}


		}

	}
	private void downloadData(final GetDatatableParm getDataParm,final WebDataService wds, final ArrayList data,final int diff,boolean endofrows ){

		final WebClientConnection wcc = ConnectionChangeReceiver.getInstence().systemwcc;
		if (endofrows){
			prodialog.dismiss();
			return;

		}
		else { prodialog.incrementProgressBy(diff);}

		wds.retrieve(getDataParm, wcc, new WebDataNotifier(){

			@Override
			public void result(DataResult result) {
				// TODO Auto-generated method stub
				if (result.error==0 && result.total>0 && getDataParm.pagesize>0 && result.data.size() >0)
				{
					data.add(result.data);
					getDataParm.pageindex++;
					int diff=100/(result.total/getDataParm.pagesize);
					downloadData(getDataParm,wds,data,diff,false);





				}
				else
				{
					downloadData(getDataParm,wds,data,diff,true);

				}

			}

		});




	}
	private void prePareDownloadData( ){





		final GetDatatableParm getDataParm=new GetDatatableParm();
		final WebDataService wds=new WebDataService();
		final WebClientConnection wcc = ConnectionChangeReceiver.getInstence().systemwcc;
		final ArrayList data=new ArrayList();

		final Context context=MainActivity.this;
		final ProgressDialog prodialog = new ProgressDialog(context);
		getDataParm.resid="512140126114";
		getDataParm.pageindex=0;
		getDataParm.pagesize=50;
		getDataParm.cmswhere="C3_512140206161=20170825";
		getDataParm.cmscolumns="C3_529485594613,C3_529889657644,C3_512140206692,C3_512140206926,C3_512346252614,C3_512140206161,C3_512140208817,C3_512262270614,C3_512261452989,C3_529489922410,C3_512140205598,C3_512261273552";
		downloadData(getDataParm,wds,data,0,false);

	}
	private void testprogress(){
		/**
		 *页面属性
		 */
        /*新建ProgressDialog对象*/

        /*设置显示风格*/
		prodialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        /*设置标题*/
		prodialog.setTitle("新页面");
        /*对话框的文字信息*/
		prodialog.setMessage("请耐心等待...");
        /*对话框图标*/
		prodialog.setIcon(R.drawable.ic_launcher);

		/**
		 * 进度条属性
		 */
        /*设置最大进度*/
		prodialog.setMax(100);
        /*设置初始化进度*/

        /*设置进度条明确显示进度*/
		prodialog.setIndeterminate(false);

		/**
		 * 设定确定按钮
		 */
        /*参数一：按钮类型，参数二：按钮文字，参数三：按钮监听器*/
		prodialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				Toast.makeText(MainActivity.this,"欢迎",Toast.LENGTH_SHORT).show();
			}
		});
        /*是否可以通过返回按钮退出对话框*/
		prodialog.setCancelable(false);
        /*显示对话框*/
		prodialog.show();
//        new Thread(new Runnable()
//        {
//            public void run()
//            {
//                try {
//					Thread.sleep(5000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//               // handler.sendMessage();//----告诉主线程执行任务
//                prodialog.incrementProgressBy(20);
//            }
//        }).start();



	}
	private void testofsqlit(){
		// showToast(mConnectivityReceiver.systemwcc.OpResult);
		SQLiteDatabase db = LitePal.getDatabase();
		try{
			String sql="create index i_posorders_cardno on PosOrders(cardno)";
			db.execSQL(sql);}
		catch (Exception e) {
			e.printStackTrace();
		}
		PosOrder posorder=new PosOrder();
		posorder.setBadgeno("0123456");
		posorder.setCardno("16740988324234");
		posorder.setOrderno("2017089820031");
		posorder.save();
	}
	private void testofwebdata(){
		GetDatatableParm getDataParm=new GetDatatableParm();
		final WebDataService wds=new WebDataService();
		getDataParm.resid="542290864273";
		getDataParm.cmswhere="C3_542290897385='556913549137'";
		wds.retrieve(getDataParm, mConnectivityReceiver.getInstence().systemwcc, new WebDataNotifier(){

			@Override
			public void result(DataResult result) {
				// TODO Auto-generated method stub
				try{
					String str=result.data.get(0).toString();
					同步监控表 test=JSON.parseObject(str, 同步监控表.class);

					showToast(	test.uniquenamesynname);
					test._id=1;
					test._state="added";
					SaveDataTableParm parm=new SaveDataTableParm();
					parm.resid="542290864273";
					parm.dataoflist.add(test);
					wds.save(parm,  mConnectivityReceiver.getInstence().systemwcc, new WebDataNotifier(){

						@Override
						public void result(DataResult result) {
							// TODO Auto-generated method stub

						}});

				}
				catch (Exception e){

				}

			}});
	}
	private void initListener() {
		// TODO Auto-generated method stub


		loginButton.setOnClickListener(this);
		downloadButton.setOnClickListener(this);

	}

}

