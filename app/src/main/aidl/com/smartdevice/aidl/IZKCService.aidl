package com.smartdevice.aidl;

import com.smartdevice.aidl.ICallBack;
import android.graphics.Bitmap;
import android.content.Context;

interface IZKCService
{

	/**
	* ���õ�ǰ����ģ��
	* @param cb:	ʵ��ICallback�ӿڵĻص�
	*/
	boolean setModuleFlag(int module);
	/************************************************************
	 *                                                        ***
	 *                 ��ӡ��                                 ***
	 *                                                        ***
	 ************************************************************/
	 
	 /**
	* ע��
	* @param cb:	ʵ��ICallback�ӿڵĻص�
	*/
	void registerCallBack(String flag,ICallBack callback); 
	
	/**
	* ע���ص�
	* @param cb:	ʵ��ICallback�ӿڵĻص�
	*/
	void unregisterCallBack(String flag,ICallBack callback);
	
	/**
	* ֹͣ�ص�����
	*/
	void stopRunningTask();
	
	/**
	* �жϻص������Ƿ���������
	*/
	boolean isTaskRunning();   
	 
	/**
	* ��ȡ��ӡ���̼��汾
	*/
	void getFirmwareVersion();
	
	/**
	* ��ȡZKCService����汾
	*/
	String getServiceVersion();
	
	/**
	* ��ȡZKCService����汾
	*/
	int getDeviceModel();	
	
	/**
	 * ��ʼ����ӡ��
	 */
	void printerInit();
	
	/**
	* ��ȡ��ӡ��״̬
	*/
	String getPrinterStatus();
	
	/**
	* ��ӡ���Լ죬��ӡ�����ӡ�Լ�ҳ
	*/
	void printerSelfChecking();
	
	/**
	* ����ӡ���Ƿ����
	*/
	boolean checkPrinterAvailable();
	
	/**
	* ʹ��ԭʼָ���ӡ
	* @param data ָ��
	* @param callback  ����ص�
	*/
	void sendRAWData(String flag,in byte[] data);
	
	/**
	* ���ö���ģʽ����֮���ӡ��Ӱ�죬���ǳ�ʼ��
	* @param alignment:	���뷽ʽ 0--����, 1--����, 2--����
	* @param callback  ����ص�
	*/
	void setAlignment(int alignment);
	
	/**
	* ���ô�ӡ����, ��֮���ӡ��Ӱ�죬���ǳ�ʼ��
	* (Ŀǰֻ֧����������)
	* @param typeface:	�������� 0--ASCII(12*24) ���֣�24*24����1--ASCII(8*16) ���֣�16*16��
	*/
	void setTypeface(int type);
	
	/**
	* ���������С, ��֮���ӡ��Ӱ�죬���ǳ�ʼ��
	* ���������С��Ӱ���ַ���ȣ�ÿ���ַ�����Ҳ����֮�ı䣬
	* @param fontsize:	�����С���� 0--�ַ������� ���Ŵ�1--�ַ� 2 ���ߣ�����Ŵ� 
	*                                2--�ַ� 2 ��������Ŵ�3--�ַ� 2 ������Ŵ� 
	*/
	void setFontSize(int type);
	
	/**
	* ��ӡ���֣����ֿ����һ���Զ������Ű棬����һ���в���ӡ����ǿ�ƻ���
	* @param text:	Ҫ��ӡ�������ַ���
	*/
	void printGBKText(String text);
	
	/**
	* ��ӡ���֣����ֿ����һ���Զ������Ű棬����һ���в���ӡ����ǿ�ƻ���
	* @param text:	Ҫ��ӡ�������ַ���
	*/
	void printUnicodeText(String text);
	
	/**
	* ��ӡָ��������ı�����������ֻ�Ա�����Ч
	* @param text:			Ҫ��ӡ����
	* @param typeface:		��������
	* @param fontsize:		�����С	����
	*/
	void printTextWithFont(String text, int type, int size);
	
	/**
	* ��ӡָ������,�ֺš����뷽ʽ���ı�����������ֻ�Ա�����Ч
	* @param text:			Ҫ��ӡ����
	* @param typeface:		��������
	* @param fontsize:		�����С	����
	* @param alginStyle:	���뷽ʽ(0����, 1����, 2����)
	*/
	void printTextAlgin(String text, int type, int size, int alginStyle);
	
	/**
	* ��ӡ����һ�У�����ָ���п����뷽ʽ
	* @param colsTextArr   �����ı��ַ�������
	* @param colsWidthArr  ���п������(��Ӣ���ַ�����, ÿ�������ַ�ռ����Ӣ���ַ�, ÿ����ȴ���0)
	* @param colsAlign	        ���ж��뷽ʽ(0����, 1����, 2����)
	* ��ע: �������������鳤��Ӧ��һ��, ���colsText[i]�Ŀ�ȴ���colsWidth[i], ���ı�����
	*/
	void printColumnsText(in String[] colsTextArr, in int[] colsWidthArr, in int[] colsAlign);
	
	/**
	* ��ӡͼƬ
	* @param bitmap: 	ͼƬbitmap����
	*/
	void printBitmap(in Bitmap bitmap);
	
	/**
	* ��ӡͼƬ�������뷽ʽ��
	* @param bitmap: 	ͼƬbitmap����
	* @parm position:   ͼƬλ�� 0--����1--���У�2--����
	*/
	void printBitmapAlgin(in Bitmap bitmap, int width, int height,int position);
	
	/**
	* ����һά����ͼƬ
	* @param data: 		��������
	* @param symbology: 	��������
	*    0 -- UPC-A��
	*    1 -- UPC-E��
	*    2 -- JAN13(EAN13)��
	*    3 -- JAN8(EAN8)��
	*    4 -- CODE39��
	*    5 -- ITF��
	*    6 -- CODABAR��
	*    7 -- CODE93��
	*    8 -- CODE128
	* @param height: 		����߶�, ȡֵ1��255, Ĭ��162
	* @param width: 		������, ȡֵ0��5, Ĭ��3
	* @param displayText:	�Ƿ���ʾ����
	*/
	Bitmap createBarCode(String data, int codeFormat, int width, int height, boolean displayText);
	
	/**
	* ������ά����ͼƬ
	* @param data:			��ά������
	* @param modulesize:	��ά����С(��λ:��, ȡֵ 1 �� 16 )
	*/
	Bitmap createQRCode(String data, int width, int height);
	
	/********************************
	********������� 2017/03/14******
	*********************************/
	
	/*
	*��ӡ���ɽ���ȡ��϶
	*/
	void generateSpace();
	
	/********************************
	********������� 2017/04/25******
	*********************************/
	
	/*
	*��ӡͼƬ���Ҷȣ�
	*/
	boolean printImageGray(in Bitmap bitmap);
	
	/*
	*��ӡͼƬ����դ��
	*/
	boolean printRasterImage(in Bitmap bitmap);
	
	/*
	*��ӡUNINCODE����դ��
	*/
	boolean printUnicode_1F30(String textStr);
	
	/*
	*���ô�ӡ����
	*/
	void setPrintLanguage(String language);
	
	/*
	*��ȡ�̼��汾
	*/
	String getFirmwareVersion1();
	
	/*
	*��ȡ�̼��汾
	*/
	String getFirmwareVersion2();
	
	
	
	/************************************************************
	 *                                                        ***
	 *                 ������                                 ***
	 *                                                        ***
	 ************************************************************/
	 
	 /**
	 * �����������Դ
	 * @param btFlg ���Ʊ������� 0===������1===������
	 */
	 
	 void openBackLight(int btFlg);
	 
	 /**
	 *  ��ʾ��ɫͼƬ��ͼƬ��ʽ����
	 * @param bitmapSrc ��ʾͼƬλͼ
	 */
	 
	 boolean showRGB565Image(in Bitmap bitmapSrc);
	 
	 /**
	 *  ��ʾ��ɫͼƬ��ͼƬ��ʽ����
	 * @param path ͼƬ·��
	 */
	 
	 boolean showRGB565ImageByPath(String path);
	 
	 /**
	 * ָ��λ����ʾ��ɫͼƬ��ͼƬ��ʽ����
	 * @param bitmapSrc
	 *            ͼƬ
	 * @param x
	 *            ���X����
	 * @param y
	 *            ���Y����
	 * @param width
	 *            ��ʾ���
	 * @param height
	 *            ��ʾ�߶�
	 * @return
	 */
	 
	 boolean showRGB565ImageLocation(in Bitmap bitmapSrc,int x, int y, int width, int height);
	 
	 /**
	 * ������ĻLOGO
	 * @param bitmapSrc
	 * @return
	 */
	 
	 boolean updateLogo(in Bitmap bitmapSrc);
	 
	 /**
	 * ������ĻLOGO
	 * @param path
	 * @return
	 */
	 
	 boolean updateLogoByPath(String path);
	 
	 /**
	 * ��ʾ˫ɫͼƬ
	 * 
	 * @param BackColor
	 * @param ForeColor
	 * @param bitmapSrc
	 * @return
	 */
	 
	 boolean showDotImage(int BackColor, int ForeColor,in Bitmap bitmapSrc);
	 
	  /**
	 * ��Ļ������ʾ��ɫͼƬ
	 * @param bitmapSrc
	 * @return
	 */
	 
	 boolean showRGB565ImageCenter(in Bitmap bitmapSrc);
	 
	 /************************************************************
	 *                                                        ***
	 *                	PSAM��                                ***
	 *                                                        ***
	 ************************************************************/
	 
	/**
	* ��PSAM��Դ
	*/
	
	int Open();
	
	/**
	* �ر�PSAM��Դ
	*/
	
	int Close(long fd);
	 
	/**
	* ��/�ر�GPIO��
	* @return  true--success; false--fail
	*/
	
	boolean setGPIO(int io,int status);
	 
	/**
	* ��ָ��PSAM��
	* @param carPositin: PSAM��λ��
	* @return ����0�ɹ�
	*/
	
	int openCard(int carPositin);
	
	/**
	 * ���豸2
	 * 
	 * @param ���۱��
	 */

	int openCard2(inout int[] fd,int slotno);
	
	/**
	 * ���豸3
	 * 
	 * @param ���۱��
	 */

	int openCard3(long fd,int slotno);
	
	/**
	* �رմ򿪵�PSAM��
	* @return ����0�ɹ�
	*/
	int CloseCard();
	
	/**  
	 *���ܣ�	�ر��豸2 
	 *c���� v2 true:�豸3/�豸2
	 *������ [in]unsigned long fd����Ҫ�رյ��豸���
	 *����ֵ����ȷΪ0������Ϊ��0              
	*/

	int CloseCard2(long fd, boolean v2);
	
	/**
	* ���õ�ǰ�򿪵�PSAM��
	* @param power: ָ���ĵ�ѹ��С
	* @return ���ֽ����鷵��PSAM����
	*/
	byte[] ResetCard(int power);
	
	/**      
	 *���ܣ�	�豸��λ2
	 *������ [in]unsigned long fd����Ҫ�رյ��豸���
	 *       [out]unsigned char *atr �����豸��λ��Ϣ
	 *       [in/out]int *atrLen �����豸��λ��Ϣ����
	 *����ֵ����ȷΪ0������Ϊ��0
	*/

	int ResetCard2(long fd, inout byte[] atr,inout int[] atrLen);
	
	/**      
	 *���ܣ�	�豸��λ3
	 *������ [in]unsigned long fd����Ҫ�رյ��豸���
	 *       [out]unsigned char *atr �����豸��λ��Ϣ
	 *       [in/out]int *atrLen �����豸��λ��Ϣ����
	 *����ֵ����ȷΪ0������Ϊ��0
	*/

	byte[] ResetCard3(long fd,int slotno,int pw);
	
	/**
	* ����ǰPSAM������APDU����
	* @param apdu: APDU����
	* @return ���ֽ����鷵��������
	*/
	byte[] CardApdu(in byte[] apdu);
	
	/**      
	 *���ܣ�	����APDUָ��2
	 *������ [in]unsigned long fd�����豸���
	 *     [in]unsigned char *apdu Ҫ���͵�apduָ��
	 *     [in]int apduLength Ҫ���͵�apduָ���
	 *     [out]unsigned char*response ������������
	 *     [in/out]int* respLength �������ݳ���
	 *����ֵ����ȷΪ0������Ϊ��0
	 *ע�⣺�˽ӿڲ�ִ���Զ�ȡ��Ӧ���ݣ����˽ӿڲ��Զ����͡�00c0������ȡ��Ӧָ�
	*/

	int CardApdu2(long fd, in byte[] apdu,int apduLength, inout byte[] response,inout int[] respLength);
	
	/**      
	 *���ܣ�	����APDUָ��3
	 *������ [in]unsigned long fd�����豸���
	 *     [in]unsigned char *apdu Ҫ���͵�apduָ��
	 *     [in]int apduLength Ҫ���͵�apduָ���
	 *     [out]unsigned char*response ������������
	 *     [in/out]int* respLength �������ݳ���
	 *����ֵ����ȷΪ0������Ϊ��0
	 *ע�⣺�˽ӿڲ�ִ���Զ�ȡ��Ӧ���ݣ����˽ӿڲ��Զ����͡�00c0������ȡ��Ӧָ�
	*/

	byte[] CardApdu3(long fd, in byte[] apdu,int apduLength);
	
	/************************************************************
	 *                                                        ***
	 *                	ɨ��                                  ***
	 *                                                        ***
	 ************************************************************/
	
	/**
	* ��ɨ��
	* @param status: true:�򿪣�false:�ر�
	*/
	void openScan(boolean status);
	
	/**
	* ɨ��
	*/
	void scan();
	
	/**
	* ����ĩβ׷�ӻس�
	* @param status: true:׷�ӣ�false:��׷��
	*/
	void dataAppendEnter(boolean  status);
	
	/**
	* ɨ��ɹ���ʾ��
	* @param status:  true:��Ҫ��false:����Ҫ
	*/
	void appendRingTone(boolean status);
	
	/**
	* ����ɨ��
	* @param status: true:��Ҫ��false:����Ҫ
	*/
	void continueScan(boolean status);
	
	/**
	* ɨ���ظ���ʾ
	* @param status: true:��ʾ��false:����ʾ
	*/
	void scanRepeatHint(boolean status);
	
	/**
	* �ָ���������
	* @param status: true:������Ч��false:���ò���Ч
	*/
	void recoveryFactorySet(boolean status);
	
	/**
	* ����ɨ��ָ��
	* @param byte[] ���͵�ָ������
	* @return ���յĽ��
	*/	
	byte[] sendCommand(in byte[] buffer);
	
	/**
	* �Ƿ��������ɨ��
	* @return true:ɨ���Ѵ򿪣�false:ɨ���ѹرգ�
	*/	
	boolean isScanning();
	
	/**
	* ��ȡ���֤��Ϣ
	* @return ���֤��Ϣ
	*/
	String getIdentifyInfo();

}