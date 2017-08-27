/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\github\\andriodWebPos\\AndriodPos\\app\\src\\main\\aidl\\com\\smartdevice\\aidl\\IZKCService.aidl
 */
package com.smartdevice.aidl;
public interface IZKCService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.smartdevice.aidl.IZKCService
{
private static final java.lang.String DESCRIPTOR = "com.smartdevice.aidl.IZKCService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.smartdevice.aidl.IZKCService interface,
 * generating a proxy if needed.
 */
public static com.smartdevice.aidl.IZKCService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.smartdevice.aidl.IZKCService))) {
return ((com.smartdevice.aidl.IZKCService)iin);
}
return new com.smartdevice.aidl.IZKCService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_setModuleFlag:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.setModuleFlag(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_registerCallBack:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
com.smartdevice.aidl.ICallBack _arg1;
_arg1 = com.smartdevice.aidl.ICallBack.Stub.asInterface(data.readStrongBinder());
this.registerCallBack(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_unregisterCallBack:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
com.smartdevice.aidl.ICallBack _arg1;
_arg1 = com.smartdevice.aidl.ICallBack.Stub.asInterface(data.readStrongBinder());
this.unregisterCallBack(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_stopRunningTask:
{
data.enforceInterface(DESCRIPTOR);
this.stopRunningTask();
reply.writeNoException();
return true;
}
case TRANSACTION_isTaskRunning:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isTaskRunning();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getFirmwareVersion:
{
data.enforceInterface(DESCRIPTOR);
this.getFirmwareVersion();
reply.writeNoException();
return true;
}
case TRANSACTION_getServiceVersion:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getServiceVersion();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getDeviceModel:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getDeviceModel();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_printerInit:
{
data.enforceInterface(DESCRIPTOR);
this.printerInit();
reply.writeNoException();
return true;
}
case TRANSACTION_getPrinterStatus:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getPrinterStatus();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_printerSelfChecking:
{
data.enforceInterface(DESCRIPTOR);
this.printerSelfChecking();
reply.writeNoException();
return true;
}
case TRANSACTION_checkPrinterAvailable:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.checkPrinterAvailable();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_sendRAWData:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
byte[] _arg1;
_arg1 = data.createByteArray();
this.sendRAWData(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_setAlignment:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.setAlignment(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setTypeface:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.setTypeface(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setFontSize:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.setFontSize(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_printGBKText:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.printGBKText(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_printUnicodeText:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.printUnicodeText(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_printTextWithFont:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
this.printTextWithFont(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_printTextAlgin:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
this.printTextAlgin(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_printColumnsText:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _arg0;
_arg0 = data.createStringArray();
int[] _arg1;
_arg1 = data.createIntArray();
int[] _arg2;
_arg2 = data.createIntArray();
this.printColumnsText(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_printBitmap:
{
data.enforceInterface(DESCRIPTOR);
android.graphics.Bitmap _arg0;
if ((0!=data.readInt())) {
_arg0 = android.graphics.Bitmap.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.printBitmap(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_printBitmapAlgin:
{
data.enforceInterface(DESCRIPTOR);
android.graphics.Bitmap _arg0;
if ((0!=data.readInt())) {
_arg0 = android.graphics.Bitmap.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
this.printBitmapAlgin(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_createBarCode:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
boolean _arg4;
_arg4 = (0!=data.readInt());
android.graphics.Bitmap _result = this.createBarCode(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_createQRCode:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
android.graphics.Bitmap _result = this.createQRCode(_arg0, _arg1, _arg2);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_generateSpace:
{
data.enforceInterface(DESCRIPTOR);
this.generateSpace();
reply.writeNoException();
return true;
}
case TRANSACTION_printImageGray:
{
data.enforceInterface(DESCRIPTOR);
android.graphics.Bitmap _arg0;
if ((0!=data.readInt())) {
_arg0 = android.graphics.Bitmap.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _result = this.printImageGray(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_printRasterImage:
{
data.enforceInterface(DESCRIPTOR);
android.graphics.Bitmap _arg0;
if ((0!=data.readInt())) {
_arg0 = android.graphics.Bitmap.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _result = this.printRasterImage(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_printUnicode_1F30:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.printUnicode_1F30(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setPrintLanguage:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.setPrintLanguage(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getFirmwareVersion1:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getFirmwareVersion1();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getFirmwareVersion2:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getFirmwareVersion2();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_openBackLight:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.openBackLight(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_showRGB565Image:
{
data.enforceInterface(DESCRIPTOR);
android.graphics.Bitmap _arg0;
if ((0!=data.readInt())) {
_arg0 = android.graphics.Bitmap.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _result = this.showRGB565Image(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_showRGB565ImageByPath:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.showRGB565ImageByPath(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_showRGB565ImageLocation:
{
data.enforceInterface(DESCRIPTOR);
android.graphics.Bitmap _arg0;
if ((0!=data.readInt())) {
_arg0 = android.graphics.Bitmap.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
int _arg4;
_arg4 = data.readInt();
boolean _result = this.showRGB565ImageLocation(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_updateLogo:
{
data.enforceInterface(DESCRIPTOR);
android.graphics.Bitmap _arg0;
if ((0!=data.readInt())) {
_arg0 = android.graphics.Bitmap.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _result = this.updateLogo(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_updateLogoByPath:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _result = this.updateLogoByPath(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_showDotImage:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
android.graphics.Bitmap _arg2;
if ((0!=data.readInt())) {
_arg2 = android.graphics.Bitmap.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
boolean _result = this.showDotImage(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_showRGB565ImageCenter:
{
data.enforceInterface(DESCRIPTOR);
android.graphics.Bitmap _arg0;
if ((0!=data.readInt())) {
_arg0 = android.graphics.Bitmap.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
boolean _result = this.showRGB565ImageCenter(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_Open:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.Open();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_Close:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
int _result = this.Close(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setGPIO:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
boolean _result = this.setGPIO(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_openCard:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _result = this.openCard(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_openCard2:
{
data.enforceInterface(DESCRIPTOR);
int[] _arg0;
_arg0 = data.createIntArray();
int _arg1;
_arg1 = data.readInt();
int _result = this.openCard2(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
reply.writeIntArray(_arg0);
return true;
}
case TRANSACTION_openCard3:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
int _arg1;
_arg1 = data.readInt();
int _result = this.openCard3(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_CloseCard:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.CloseCard();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_CloseCard2:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
boolean _arg1;
_arg1 = (0!=data.readInt());
int _result = this.CloseCard2(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_ResetCard:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
byte[] _result = this.ResetCard(_arg0);
reply.writeNoException();
reply.writeByteArray(_result);
return true;
}
case TRANSACTION_ResetCard2:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
byte[] _arg1;
_arg1 = data.createByteArray();
int[] _arg2;
_arg2 = data.createIntArray();
int _result = this.ResetCard2(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(_result);
reply.writeByteArray(_arg1);
reply.writeIntArray(_arg2);
return true;
}
case TRANSACTION_ResetCard3:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
byte[] _result = this.ResetCard3(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeByteArray(_result);
return true;
}
case TRANSACTION_CardApdu:
{
data.enforceInterface(DESCRIPTOR);
byte[] _arg0;
_arg0 = data.createByteArray();
byte[] _result = this.CardApdu(_arg0);
reply.writeNoException();
reply.writeByteArray(_result);
return true;
}
case TRANSACTION_CardApdu2:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
byte[] _arg1;
_arg1 = data.createByteArray();
int _arg2;
_arg2 = data.readInt();
byte[] _arg3;
_arg3 = data.createByteArray();
int[] _arg4;
_arg4 = data.createIntArray();
int _result = this.CardApdu2(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
reply.writeInt(_result);
reply.writeByteArray(_arg3);
reply.writeIntArray(_arg4);
return true;
}
case TRANSACTION_CardApdu3:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
byte[] _arg1;
_arg1 = data.createByteArray();
int _arg2;
_arg2 = data.readInt();
byte[] _result = this.CardApdu3(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeByteArray(_result);
return true;
}
case TRANSACTION_openScan:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.openScan(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_scan:
{
data.enforceInterface(DESCRIPTOR);
this.scan();
reply.writeNoException();
return true;
}
case TRANSACTION_dataAppendEnter:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.dataAppendEnter(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_appendRingTone:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.appendRingTone(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_continueScan:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.continueScan(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_scanRepeatHint:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.scanRepeatHint(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_recoveryFactorySet:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
this.recoveryFactorySet(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_sendCommand:
{
data.enforceInterface(DESCRIPTOR);
byte[] _arg0;
_arg0 = data.createByteArray();
byte[] _result = this.sendCommand(_arg0);
reply.writeNoException();
reply.writeByteArray(_result);
return true;
}
case TRANSACTION_isScanning:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isScanning();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getIdentifyInfo:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getIdentifyInfo();
reply.writeNoException();
reply.writeString(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.smartdevice.aidl.IZKCService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
	* ���õ�ǰ����ģ��
	* @param cb:	ʵ��ICallback�ӿڵĻص�
	*/
@Override public boolean setModuleFlag(int module) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(module);
mRemote.transact(Stub.TRANSACTION_setModuleFlag, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/************************************************************
	 *                                                        ***
	 *                 ��ӡ��                                 ***
	 *                                                        ***
	 ************************************************************//**
	* ע��
	* @param cb:	ʵ��ICallback�ӿڵĻص�
	*/
@Override public void registerCallBack(java.lang.String flag, com.smartdevice.aidl.ICallBack callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(flag);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerCallBack, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	* ע���ص�
	* @param cb:	ʵ��ICallback�ӿڵĻص�
	*/
@Override public void unregisterCallBack(java.lang.String flag, com.smartdevice.aidl.ICallBack callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(flag);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregisterCallBack, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	* ֹͣ�ص�����
	*/
@Override public void stopRunningTask() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_stopRunningTask, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	* �жϻص������Ƿ���������
	*/
@Override public boolean isTaskRunning() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isTaskRunning, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	* ��ȡ��ӡ���̼��汾
	*/
@Override public void getFirmwareVersion() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getFirmwareVersion, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public java.lang.String getServiceVersion() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getServiceVersion, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int getDeviceModel() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getDeviceModel, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * ��ʼ����ӡ��
	 */
@Override public void printerInit() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_printerInit, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public java.lang.String getPrinterStatus() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPrinterStatus, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	* ��ӡ���Լ죬��ӡ�����ӡ�Լ�ҳ
	*/
@Override public void printerSelfChecking() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_printerSelfChecking, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	* ����ӡ���Ƿ����
	*/
@Override public boolean checkPrinterAvailable() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_checkPrinterAvailable, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	* ʹ��ԭʼָ���ӡ
	* @param data ָ��
	* @param callback  ����ص�
	*/
@Override public void sendRAWData(java.lang.String flag, byte[] data) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(flag);
_data.writeByteArray(data);
mRemote.transact(Stub.TRANSACTION_sendRAWData, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	* ���ö���ģʽ����֮���ӡ��Ӱ�죬���ǳ�ʼ��
	* @param alignment:	���뷽ʽ 0--����, 1--����, 2--����
	* @param callback  ����ص�
	*/
@Override public void setAlignment(int alignment) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(alignment);
mRemote.transact(Stub.TRANSACTION_setAlignment, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	* ���ô�ӡ����, ��֮���ӡ��Ӱ�죬���ǳ�ʼ��
	* (Ŀǰֻ֧����������)
	* @param typeface:	�������� 0--ASCII(12*24) ���֣�24*24����1--ASCII(8*16) ���֣�16*16��
	*/
@Override public void setTypeface(int type) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(type);
mRemote.transact(Stub.TRANSACTION_setTypeface, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	* ���������С, ��֮���ӡ��Ӱ�죬���ǳ�ʼ��
	* ���������С��Ӱ���ַ���ȣ�ÿ���ַ�����Ҳ����֮�ı䣬
	* @param fontsize:	�����С���� 0--�ַ������� ���Ŵ�1--�ַ� 2 ���ߣ�����Ŵ� 
	*                                2--�ַ� 2 ��������Ŵ�3--�ַ� 2 ������Ŵ� 
	*/
@Override public void setFontSize(int type) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(type);
mRemote.transact(Stub.TRANSACTION_setFontSize, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	* ��ӡ���֣����ֿ����һ���Զ������Ű棬����һ���в���ӡ����ǿ�ƻ���
	* @param text:	Ҫ��ӡ�������ַ���
	*/
@Override public void printGBKText(java.lang.String text) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(text);
mRemote.transact(Stub.TRANSACTION_printGBKText, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	* ��ӡ���֣����ֿ����һ���Զ������Ű棬����һ���в���ӡ����ǿ�ƻ���
	* @param text:	Ҫ��ӡ�������ַ���
	*/
@Override public void printUnicodeText(java.lang.String text) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(text);
mRemote.transact(Stub.TRANSACTION_printUnicodeText, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	* ��ӡָ��������ı�����������ֻ�Ա�����Ч
	* @param text:			Ҫ��ӡ����
	* @param typeface:		��������
	* @param fontsize:		�����С	����
	*/
@Override public void printTextWithFont(java.lang.String text, int type, int size) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(text);
_data.writeInt(type);
_data.writeInt(size);
mRemote.transact(Stub.TRANSACTION_printTextWithFont, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	* ��ӡָ������,�ֺš����뷽ʽ���ı�����������ֻ�Ա�����Ч
	* @param text:			Ҫ��ӡ����
	* @param typeface:		��������
	* @param fontsize:		�����С	����
	* @param alginStyle:	���뷽ʽ(0����, 1����, 2����)
	*/
@Override public void printTextAlgin(java.lang.String text, int type, int size, int alginStyle) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(text);
_data.writeInt(type);
_data.writeInt(size);
_data.writeInt(alginStyle);
mRemote.transact(Stub.TRANSACTION_printTextAlgin, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	* ��ӡ����һ�У�����ָ���п����뷽ʽ
	* @param colsTextArr   �����ı��ַ�������
	* @param colsWidthArr  ���п������(��Ӣ���ַ�����, ÿ�������ַ�ռ����Ӣ���ַ�, ÿ����ȴ���0)
	* @param colsAlign	        ���ж��뷽ʽ(0����, 1����, 2����)
	* ��ע: �������������鳤��Ӧ��һ��, ���colsText[i]�Ŀ�ȴ���colsWidth[i], ���ı�����
	*/
@Override public void printColumnsText(java.lang.String[] colsTextArr, int[] colsWidthArr, int[] colsAlign) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStringArray(colsTextArr);
_data.writeIntArray(colsWidthArr);
_data.writeIntArray(colsAlign);
mRemote.transact(Stub.TRANSACTION_printColumnsText, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	* ��ӡͼƬ
	* @param bitmap: 	ͼƬbitmap����
	*/
@Override public void printBitmap(android.graphics.Bitmap bitmap) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((bitmap!=null)) {
_data.writeInt(1);
bitmap.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_printBitmap, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	* ��ӡͼƬ�������뷽ʽ��
	* @param bitmap: 	ͼƬbitmap����
	* @parm position:   ͼƬλ�� 0--����1--���У�2--����
	*/
@Override public void printBitmapAlgin(android.graphics.Bitmap bitmap, int width, int height, int position) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((bitmap!=null)) {
_data.writeInt(1);
bitmap.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(width);
_data.writeInt(height);
_data.writeInt(position);
mRemote.transact(Stub.TRANSACTION_printBitmapAlgin, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
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
@Override public android.graphics.Bitmap createBarCode(java.lang.String data, int codeFormat, int width, int height, boolean displayText) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.graphics.Bitmap _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(data);
_data.writeInt(codeFormat);
_data.writeInt(width);
_data.writeInt(height);
_data.writeInt(((displayText)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_createBarCode, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.graphics.Bitmap.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	* ������ά����ͼƬ
	* @param data:			��ά������
	* @param modulesize:	��ά����С(��λ:��, ȡֵ 1 �� 16 )
	*/
@Override public android.graphics.Bitmap createQRCode(java.lang.String data, int width, int height) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.graphics.Bitmap _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(data);
_data.writeInt(width);
_data.writeInt(height);
mRemote.transact(Stub.TRANSACTION_createQRCode, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.graphics.Bitmap.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/********************************
	********������� 2017/03/14******
	*********************************//*
	*��ӡ���ɽ���ȡ��϶
	*/
@Override public void generateSpace() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_generateSpace, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/********************************
	********������� 2017/04/25******
	*********************************//*
	*��ӡͼƬ���Ҷȣ�
	*/
@Override public boolean printImageGray(android.graphics.Bitmap bitmap) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((bitmap!=null)) {
_data.writeInt(1);
bitmap.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_printImageGray, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/*
	*��ӡͼƬ����դ��
	*/
@Override public boolean printRasterImage(android.graphics.Bitmap bitmap) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((bitmap!=null)) {
_data.writeInt(1);
bitmap.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_printRasterImage, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/*
	*��ӡUNINCODE����դ��
	*/
@Override public boolean printUnicode_1F30(java.lang.String textStr) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(textStr);
mRemote.transact(Stub.TRANSACTION_printUnicode_1F30, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/*
	*���ô�ӡ����
	*/
@Override public void setPrintLanguage(java.lang.String language) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(language);
mRemote.transact(Stub.TRANSACTION_setPrintLanguage, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public java.lang.String getFirmwareVersion1() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getFirmwareVersion1, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String getFirmwareVersion2() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getFirmwareVersion2, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/************************************************************
	 *                                                        ***
	 *                 ������                                 ***
	 *                                                        ***
	 ************************************************************//**
	 * �����������Դ
	 * @param btFlg ���Ʊ������� 0===������1===������
	 */
@Override public void openBackLight(int btFlg) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(btFlg);
mRemote.transact(Stub.TRANSACTION_openBackLight, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 *  ��ʾ��ɫͼƬ��ͼƬ��ʽ����
	 * @param bitmapSrc ��ʾͼƬλͼ
	 */
@Override public boolean showRGB565Image(android.graphics.Bitmap bitmapSrc) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((bitmapSrc!=null)) {
_data.writeInt(1);
bitmapSrc.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_showRGB565Image, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 *  ��ʾ��ɫͼƬ��ͼƬ��ʽ����
	 * @param path ͼƬ·��
	 */
@Override public boolean showRGB565ImageByPath(java.lang.String path) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(path);
mRemote.transact(Stub.TRANSACTION_showRGB565ImageByPath, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
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
@Override public boolean showRGB565ImageLocation(android.graphics.Bitmap bitmapSrc, int x, int y, int width, int height) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((bitmapSrc!=null)) {
_data.writeInt(1);
bitmapSrc.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(x);
_data.writeInt(y);
_data.writeInt(width);
_data.writeInt(height);
mRemote.transact(Stub.TRANSACTION_showRGB565ImageLocation, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * ������ĻLOGO
	 * @param bitmapSrc
	 * @return
	 */
@Override public boolean updateLogo(android.graphics.Bitmap bitmapSrc) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((bitmapSrc!=null)) {
_data.writeInt(1);
bitmapSrc.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_updateLogo, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * ������ĻLOGO
	 * @param path
	 * @return
	 */
@Override public boolean updateLogoByPath(java.lang.String path) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(path);
mRemote.transact(Stub.TRANSACTION_updateLogoByPath, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * ��ʾ˫ɫͼƬ
	 * 
	 * @param BackColor
	 * @param ForeColor
	 * @param bitmapSrc
	 * @return
	 */
@Override public boolean showDotImage(int BackColor, int ForeColor, android.graphics.Bitmap bitmapSrc) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(BackColor);
_data.writeInt(ForeColor);
if ((bitmapSrc!=null)) {
_data.writeInt(1);
bitmapSrc.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_showDotImage, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * ��Ļ������ʾ��ɫͼƬ
	 * @param bitmapSrc
	 * @return
	 */
@Override public boolean showRGB565ImageCenter(android.graphics.Bitmap bitmapSrc) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((bitmapSrc!=null)) {
_data.writeInt(1);
bitmapSrc.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_showRGB565ImageCenter, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int Open() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_Open, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int Close(long fd) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(fd);
mRemote.transact(Stub.TRANSACTION_Close, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	* ��/�ر�GPIO��
	* @return  true--success; false--fail
	*/
@Override public boolean setGPIO(int io, int status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(io);
_data.writeInt(status);
mRemote.transact(Stub.TRANSACTION_setGPIO, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int openCard(int carPositin) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(carPositin);
mRemote.transact(Stub.TRANSACTION_openCard, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int openCard2(int[] fd, int slotno) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeIntArray(fd);
_data.writeInt(slotno);
mRemote.transact(Stub.TRANSACTION_openCard2, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
_reply.readIntArray(fd);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int openCard3(long fd, int slotno) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(fd);
_data.writeInt(slotno);
mRemote.transact(Stub.TRANSACTION_openCard3, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int CloseCard() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_CloseCard, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int CloseCard2(long fd, boolean v2) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(fd);
_data.writeInt(((v2)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_CloseCard2, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	* ���õ�ǰ�򿪵�PSAM��
	* @param power: ָ���ĵ�ѹ��С
	* @return ���ֽ����鷵��PSAM����
	*/
@Override public byte[] ResetCard(int power) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
byte[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(power);
mRemote.transact(Stub.TRANSACTION_ResetCard, _data, _reply, 0);
_reply.readException();
_result = _reply.createByteArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int ResetCard2(long fd, byte[] atr, int[] atrLen) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(fd);
_data.writeByteArray(atr);
_data.writeIntArray(atrLen);
mRemote.transact(Stub.TRANSACTION_ResetCard2, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
_reply.readByteArray(atr);
_reply.readIntArray(atrLen);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**      
	 *���ܣ�	�豸��λ3
	 *������ [in]unsigned long fd����Ҫ�رյ��豸���
	 *       [out]unsigned char *atr �����豸��λ��Ϣ
	 *       [in/out]int *atrLen �����豸��λ��Ϣ����
	 *����ֵ����ȷΪ0������Ϊ��0
	*/
@Override public byte[] ResetCard3(long fd, int slotno, int pw) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
byte[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(fd);
_data.writeInt(slotno);
_data.writeInt(pw);
mRemote.transact(Stub.TRANSACTION_ResetCard3, _data, _reply, 0);
_reply.readException();
_result = _reply.createByteArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	* ����ǰPSAM������APDU����
	* @param apdu: APDU����
	* @return ���ֽ����鷵��������
	*/
@Override public byte[] CardApdu(byte[] apdu) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
byte[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeByteArray(apdu);
mRemote.transact(Stub.TRANSACTION_CardApdu, _data, _reply, 0);
_reply.readException();
_result = _reply.createByteArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int CardApdu2(long fd, byte[] apdu, int apduLength, byte[] response, int[] respLength) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(fd);
_data.writeByteArray(apdu);
_data.writeInt(apduLength);
_data.writeByteArray(response);
_data.writeIntArray(respLength);
mRemote.transact(Stub.TRANSACTION_CardApdu2, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
_reply.readByteArray(response);
_reply.readIntArray(respLength);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
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
@Override public byte[] CardApdu3(long fd, byte[] apdu, int apduLength) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
byte[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(fd);
_data.writeByteArray(apdu);
_data.writeInt(apduLength);
mRemote.transact(Stub.TRANSACTION_CardApdu3, _data, _reply, 0);
_reply.readException();
_result = _reply.createByteArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/************************************************************
	 *                                                        ***
	 *                	ɨ��                                  ***
	 *                                                        ***
	 ************************************************************//**
	* ��ɨ��
	* @param status: true:�򿪣�false:�ر�
	*/
@Override public void openScan(boolean status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((status)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_openScan, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	* ɨ��
	*/
@Override public void scan() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_scan, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	* ����ĩβ׷�ӻس�
	* @param status: true:׷�ӣ�false:��׷��
	*/
@Override public void dataAppendEnter(boolean status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((status)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_dataAppendEnter, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	* ɨ��ɹ���ʾ��
	* @param status:  true:��Ҫ��false:����Ҫ
	*/
@Override public void appendRingTone(boolean status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((status)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_appendRingTone, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	* ����ɨ��
	* @param status: true:��Ҫ��false:����Ҫ
	*/
@Override public void continueScan(boolean status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((status)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_continueScan, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	* ɨ���ظ���ʾ
	* @param status: true:��ʾ��false:����ʾ
	*/
@Override public void scanRepeatHint(boolean status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((status)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_scanRepeatHint, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	* �ָ���������
	* @param status: true:������Ч��false:���ò���Ч
	*/
@Override public void recoveryFactorySet(boolean status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((status)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_recoveryFactorySet, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	* ����ɨ��ָ��
	* @param byte[] ���͵�ָ������
	* @return ���յĽ��
	*/
@Override public byte[] sendCommand(byte[] buffer) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
byte[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeByteArray(buffer);
mRemote.transact(Stub.TRANSACTION_sendCommand, _data, _reply, 0);
_reply.readException();
_result = _reply.createByteArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	* �Ƿ��������ɨ��
	* @return true:ɨ���Ѵ򿪣�false:ɨ���ѹرգ�
	*/
@Override public boolean isScanning() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isScanning, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String getIdentifyInfo() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getIdentifyInfo, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_setModuleFlag = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_registerCallBack = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_unregisterCallBack = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_stopRunningTask = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_isTaskRunning = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_getFirmwareVersion = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_getServiceVersion = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_getDeviceModel = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_printerInit = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_getPrinterStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_printerSelfChecking = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_checkPrinterAvailable = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_sendRAWData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
static final int TRANSACTION_setAlignment = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
static final int TRANSACTION_setTypeface = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
static final int TRANSACTION_setFontSize = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
static final int TRANSACTION_printGBKText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
static final int TRANSACTION_printUnicodeText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
static final int TRANSACTION_printTextWithFont = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
static final int TRANSACTION_printTextAlgin = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
static final int TRANSACTION_printColumnsText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
static final int TRANSACTION_printBitmap = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
static final int TRANSACTION_printBitmapAlgin = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
static final int TRANSACTION_createBarCode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
static final int TRANSACTION_createQRCode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
static final int TRANSACTION_generateSpace = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
static final int TRANSACTION_printImageGray = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
static final int TRANSACTION_printRasterImage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 27);
static final int TRANSACTION_printUnicode_1F30 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 28);
static final int TRANSACTION_setPrintLanguage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 29);
static final int TRANSACTION_getFirmwareVersion1 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 30);
static final int TRANSACTION_getFirmwareVersion2 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 31);
static final int TRANSACTION_openBackLight = (android.os.IBinder.FIRST_CALL_TRANSACTION + 32);
static final int TRANSACTION_showRGB565Image = (android.os.IBinder.FIRST_CALL_TRANSACTION + 33);
static final int TRANSACTION_showRGB565ImageByPath = (android.os.IBinder.FIRST_CALL_TRANSACTION + 34);
static final int TRANSACTION_showRGB565ImageLocation = (android.os.IBinder.FIRST_CALL_TRANSACTION + 35);
static final int TRANSACTION_updateLogo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 36);
static final int TRANSACTION_updateLogoByPath = (android.os.IBinder.FIRST_CALL_TRANSACTION + 37);
static final int TRANSACTION_showDotImage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 38);
static final int TRANSACTION_showRGB565ImageCenter = (android.os.IBinder.FIRST_CALL_TRANSACTION + 39);
static final int TRANSACTION_Open = (android.os.IBinder.FIRST_CALL_TRANSACTION + 40);
static final int TRANSACTION_Close = (android.os.IBinder.FIRST_CALL_TRANSACTION + 41);
static final int TRANSACTION_setGPIO = (android.os.IBinder.FIRST_CALL_TRANSACTION + 42);
static final int TRANSACTION_openCard = (android.os.IBinder.FIRST_CALL_TRANSACTION + 43);
static final int TRANSACTION_openCard2 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 44);
static final int TRANSACTION_openCard3 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 45);
static final int TRANSACTION_CloseCard = (android.os.IBinder.FIRST_CALL_TRANSACTION + 46);
static final int TRANSACTION_CloseCard2 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 47);
static final int TRANSACTION_ResetCard = (android.os.IBinder.FIRST_CALL_TRANSACTION + 48);
static final int TRANSACTION_ResetCard2 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 49);
static final int TRANSACTION_ResetCard3 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 50);
static final int TRANSACTION_CardApdu = (android.os.IBinder.FIRST_CALL_TRANSACTION + 51);
static final int TRANSACTION_CardApdu2 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 52);
static final int TRANSACTION_CardApdu3 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 53);
static final int TRANSACTION_openScan = (android.os.IBinder.FIRST_CALL_TRANSACTION + 54);
static final int TRANSACTION_scan = (android.os.IBinder.FIRST_CALL_TRANSACTION + 55);
static final int TRANSACTION_dataAppendEnter = (android.os.IBinder.FIRST_CALL_TRANSACTION + 56);
static final int TRANSACTION_appendRingTone = (android.os.IBinder.FIRST_CALL_TRANSACTION + 57);
static final int TRANSACTION_continueScan = (android.os.IBinder.FIRST_CALL_TRANSACTION + 58);
static final int TRANSACTION_scanRepeatHint = (android.os.IBinder.FIRST_CALL_TRANSACTION + 59);
static final int TRANSACTION_recoveryFactorySet = (android.os.IBinder.FIRST_CALL_TRANSACTION + 60);
static final int TRANSACTION_sendCommand = (android.os.IBinder.FIRST_CALL_TRANSACTION + 61);
static final int TRANSACTION_isScanning = (android.os.IBinder.FIRST_CALL_TRANSACTION + 62);
static final int TRANSACTION_getIdentifyInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 63);
}
/**
	* ���õ�ǰ����ģ��
	* @param cb:	ʵ��ICallback�ӿڵĻص�
	*/
public boolean setModuleFlag(int module) throws android.os.RemoteException;
/************************************************************
	 *                                                        ***
	 *                 ��ӡ��                                 ***
	 *                                                        ***
	 ************************************************************//**
	* ע��
	* @param cb:	ʵ��ICallback�ӿڵĻص�
	*/
public void registerCallBack(java.lang.String flag, com.smartdevice.aidl.ICallBack callback) throws android.os.RemoteException;
/**
	* ע���ص�
	* @param cb:	ʵ��ICallback�ӿڵĻص�
	*/
public void unregisterCallBack(java.lang.String flag, com.smartdevice.aidl.ICallBack callback) throws android.os.RemoteException;
/**
	* ֹͣ�ص�����
	*/
public void stopRunningTask() throws android.os.RemoteException;
/**
	* �жϻص������Ƿ���������
	*/
public boolean isTaskRunning() throws android.os.RemoteException;
/**
	* ��ȡ��ӡ���̼��汾
	*/
public void getFirmwareVersion() throws android.os.RemoteException;
public java.lang.String getServiceVersion() throws android.os.RemoteException;
public int getDeviceModel() throws android.os.RemoteException;
/**
	 * ��ʼ����ӡ��
	 */
public void printerInit() throws android.os.RemoteException;
public java.lang.String getPrinterStatus() throws android.os.RemoteException;
/**
	* ��ӡ���Լ죬��ӡ�����ӡ�Լ�ҳ
	*/
public void printerSelfChecking() throws android.os.RemoteException;
/**
	* ����ӡ���Ƿ����
	*/
public boolean checkPrinterAvailable() throws android.os.RemoteException;
/**
	* ʹ��ԭʼָ���ӡ
	* @param data ָ��
	* @param callback  ����ص�
	*/
public void sendRAWData(java.lang.String flag, byte[] data) throws android.os.RemoteException;
/**
	* ���ö���ģʽ����֮���ӡ��Ӱ�죬���ǳ�ʼ��
	* @param alignment:	���뷽ʽ 0--����, 1--����, 2--����
	* @param callback  ����ص�
	*/
public void setAlignment(int alignment) throws android.os.RemoteException;
/**
	* ���ô�ӡ����, ��֮���ӡ��Ӱ�죬���ǳ�ʼ��
	* (Ŀǰֻ֧����������)
	* @param typeface:	�������� 0--ASCII(12*24) ���֣�24*24����1--ASCII(8*16) ���֣�16*16��
	*/
public void setTypeface(int type) throws android.os.RemoteException;
/**
	* ���������С, ��֮���ӡ��Ӱ�죬���ǳ�ʼ��
	* ���������С��Ӱ���ַ���ȣ�ÿ���ַ�����Ҳ����֮�ı䣬
	* @param fontsize:	�����С���� 0--�ַ������� ���Ŵ�1--�ַ� 2 ���ߣ�����Ŵ� 
	*                                2--�ַ� 2 ��������Ŵ�3--�ַ� 2 ������Ŵ� 
	*/
public void setFontSize(int type) throws android.os.RemoteException;
/**
	* ��ӡ���֣����ֿ����һ���Զ������Ű棬����һ���в���ӡ����ǿ�ƻ���
	* @param text:	Ҫ��ӡ�������ַ���
	*/
public void printGBKText(java.lang.String text) throws android.os.RemoteException;
/**
	* ��ӡ���֣����ֿ����һ���Զ������Ű棬����һ���в���ӡ����ǿ�ƻ���
	* @param text:	Ҫ��ӡ�������ַ���
	*/
public void printUnicodeText(java.lang.String text) throws android.os.RemoteException;
/**
	* ��ӡָ��������ı�����������ֻ�Ա�����Ч
	* @param text:			Ҫ��ӡ����
	* @param typeface:		��������
	* @param fontsize:		�����С	����
	*/
public void printTextWithFont(java.lang.String text, int type, int size) throws android.os.RemoteException;
/**
	* ��ӡָ������,�ֺš����뷽ʽ���ı�����������ֻ�Ա�����Ч
	* @param text:			Ҫ��ӡ����
	* @param typeface:		��������
	* @param fontsize:		�����С	����
	* @param alginStyle:	���뷽ʽ(0����, 1����, 2����)
	*/
public void printTextAlgin(java.lang.String text, int type, int size, int alginStyle) throws android.os.RemoteException;
/**
	* ��ӡ����һ�У�����ָ���п����뷽ʽ
	* @param colsTextArr   �����ı��ַ�������
	* @param colsWidthArr  ���п������(��Ӣ���ַ�����, ÿ�������ַ�ռ����Ӣ���ַ�, ÿ����ȴ���0)
	* @param colsAlign	        ���ж��뷽ʽ(0����, 1����, 2����)
	* ��ע: �������������鳤��Ӧ��һ��, ���colsText[i]�Ŀ�ȴ���colsWidth[i], ���ı�����
	*/
public void printColumnsText(java.lang.String[] colsTextArr, int[] colsWidthArr, int[] colsAlign) throws android.os.RemoteException;
/**
	* ��ӡͼƬ
	* @param bitmap: 	ͼƬbitmap����
	*/
public void printBitmap(android.graphics.Bitmap bitmap) throws android.os.RemoteException;
/**
	* ��ӡͼƬ�������뷽ʽ��
	* @param bitmap: 	ͼƬbitmap����
	* @parm position:   ͼƬλ�� 0--����1--���У�2--����
	*/
public void printBitmapAlgin(android.graphics.Bitmap bitmap, int width, int height, int position) throws android.os.RemoteException;
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
public android.graphics.Bitmap createBarCode(java.lang.String data, int codeFormat, int width, int height, boolean displayText) throws android.os.RemoteException;
/**
	* ������ά����ͼƬ
	* @param data:			��ά������
	* @param modulesize:	��ά����С(��λ:��, ȡֵ 1 �� 16 )
	*/
public android.graphics.Bitmap createQRCode(java.lang.String data, int width, int height) throws android.os.RemoteException;
/********************************
	********������� 2017/03/14******
	*********************************//*
	*��ӡ���ɽ���ȡ��϶
	*/
public void generateSpace() throws android.os.RemoteException;
/********************************
	********������� 2017/04/25******
	*********************************//*
	*��ӡͼƬ���Ҷȣ�
	*/
public boolean printImageGray(android.graphics.Bitmap bitmap) throws android.os.RemoteException;
/*
	*��ӡͼƬ����դ��
	*/
public boolean printRasterImage(android.graphics.Bitmap bitmap) throws android.os.RemoteException;
/*
	*��ӡUNINCODE����դ��
	*/
public boolean printUnicode_1F30(java.lang.String textStr) throws android.os.RemoteException;
/*
	*���ô�ӡ����
	*/
public void setPrintLanguage(java.lang.String language) throws android.os.RemoteException;
public java.lang.String getFirmwareVersion1() throws android.os.RemoteException;
public java.lang.String getFirmwareVersion2() throws android.os.RemoteException;
/************************************************************
	 *                                                        ***
	 *                 ������                                 ***
	 *                                                        ***
	 ************************************************************//**
	 * �����������Դ
	 * @param btFlg ���Ʊ������� 0===������1===������
	 */
public void openBackLight(int btFlg) throws android.os.RemoteException;
/**
	 *  ��ʾ��ɫͼƬ��ͼƬ��ʽ����
	 * @param bitmapSrc ��ʾͼƬλͼ
	 */
public boolean showRGB565Image(android.graphics.Bitmap bitmapSrc) throws android.os.RemoteException;
/**
	 *  ��ʾ��ɫͼƬ��ͼƬ��ʽ����
	 * @param path ͼƬ·��
	 */
public boolean showRGB565ImageByPath(java.lang.String path) throws android.os.RemoteException;
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
public boolean showRGB565ImageLocation(android.graphics.Bitmap bitmapSrc, int x, int y, int width, int height) throws android.os.RemoteException;
/**
	 * ������ĻLOGO
	 * @param bitmapSrc
	 * @return
	 */
public boolean updateLogo(android.graphics.Bitmap bitmapSrc) throws android.os.RemoteException;
/**
	 * ������ĻLOGO
	 * @param path
	 * @return
	 */
public boolean updateLogoByPath(java.lang.String path) throws android.os.RemoteException;
/**
	 * ��ʾ˫ɫͼƬ
	 * 
	 * @param BackColor
	 * @param ForeColor
	 * @param bitmapSrc
	 * @return
	 */
public boolean showDotImage(int BackColor, int ForeColor, android.graphics.Bitmap bitmapSrc) throws android.os.RemoteException;
/**
	 * ��Ļ������ʾ��ɫͼƬ
	 * @param bitmapSrc
	 * @return
	 */
public boolean showRGB565ImageCenter(android.graphics.Bitmap bitmapSrc) throws android.os.RemoteException;
public int Open() throws android.os.RemoteException;
public int Close(long fd) throws android.os.RemoteException;
/**
	* ��/�ر�GPIO��
	* @return  true--success; false--fail
	*/
public boolean setGPIO(int io, int status) throws android.os.RemoteException;
public int openCard(int carPositin) throws android.os.RemoteException;
public int openCard2(int[] fd, int slotno) throws android.os.RemoteException;
public int openCard3(long fd, int slotno) throws android.os.RemoteException;
public int CloseCard() throws android.os.RemoteException;
public int CloseCard2(long fd, boolean v2) throws android.os.RemoteException;
/**
	* ���õ�ǰ�򿪵�PSAM��
	* @param power: ָ���ĵ�ѹ��С
	* @return ���ֽ����鷵��PSAM����
	*/
public byte[] ResetCard(int power) throws android.os.RemoteException;
public int ResetCard2(long fd, byte[] atr, int[] atrLen) throws android.os.RemoteException;
/**      
	 *���ܣ�	�豸��λ3
	 *������ [in]unsigned long fd����Ҫ�رյ��豸���
	 *       [out]unsigned char *atr �����豸��λ��Ϣ
	 *       [in/out]int *atrLen �����豸��λ��Ϣ����
	 *����ֵ����ȷΪ0������Ϊ��0
	*/
public byte[] ResetCard3(long fd, int slotno, int pw) throws android.os.RemoteException;
/**
	* ����ǰPSAM������APDU����
	* @param apdu: APDU����
	* @return ���ֽ����鷵��������
	*/
public byte[] CardApdu(byte[] apdu) throws android.os.RemoteException;
public int CardApdu2(long fd, byte[] apdu, int apduLength, byte[] response, int[] respLength) throws android.os.RemoteException;
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
public byte[] CardApdu3(long fd, byte[] apdu, int apduLength) throws android.os.RemoteException;
/************************************************************
	 *                                                        ***
	 *                	ɨ��                                  ***
	 *                                                        ***
	 ************************************************************//**
	* ��ɨ��
	* @param status: true:�򿪣�false:�ر�
	*/
public void openScan(boolean status) throws android.os.RemoteException;
/**
	* ɨ��
	*/
public void scan() throws android.os.RemoteException;
/**
	* ����ĩβ׷�ӻس�
	* @param status: true:׷�ӣ�false:��׷��
	*/
public void dataAppendEnter(boolean status) throws android.os.RemoteException;
/**
	* ɨ��ɹ���ʾ��
	* @param status:  true:��Ҫ��false:����Ҫ
	*/
public void appendRingTone(boolean status) throws android.os.RemoteException;
/**
	* ����ɨ��
	* @param status: true:��Ҫ��false:����Ҫ
	*/
public void continueScan(boolean status) throws android.os.RemoteException;
/**
	* ɨ���ظ���ʾ
	* @param status: true:��ʾ��false:����ʾ
	*/
public void scanRepeatHint(boolean status) throws android.os.RemoteException;
/**
	* �ָ���������
	* @param status: true:������Ч��false:���ò���Ч
	*/
public void recoveryFactorySet(boolean status) throws android.os.RemoteException;
/**
	* ����ɨ��ָ��
	* @param byte[] ���͵�ָ������
	* @return ���յĽ��
	*/
public byte[] sendCommand(byte[] buffer) throws android.os.RemoteException;
/**
	* �Ƿ��������ɨ��
	* @return true:ɨ���Ѵ򿪣�false:ɨ���ѹرգ�
	*/
public boolean isScanning() throws android.os.RemoteException;
public java.lang.String getIdentifyInfo() throws android.os.RemoteException;
}
