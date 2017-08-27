/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\github\\andriodWebPos\\AndriodPos\\app\\src\\main\\aidl\\com\\smartdevice\\aidl\\ICallBack.aidl
 */
package com.smartdevice.aidl;
public interface ICallBack extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.smartdevice.aidl.ICallBack
{
private static final java.lang.String DESCRIPTOR = "com.smartdevice.aidl.ICallBack";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.smartdevice.aidl.ICallBack interface,
 * generating a proxy if needed.
 */
public static com.smartdevice.aidl.ICallBack asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.smartdevice.aidl.ICallBack))) {
return ((com.smartdevice.aidl.ICallBack)iin);
}
return new com.smartdevice.aidl.ICallBack.Stub.Proxy(obj);
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
case TRANSACTION_onReturnValue:
{
data.enforceInterface(DESCRIPTOR);
byte[] _arg0;
_arg0 = data.createByteArray();
int _arg1;
_arg1 = data.readInt();
this.onReturnValue(_arg0, _arg1);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.smartdevice.aidl.ICallBack
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
	 *接收打印机返回消息
	 */
@Override public void onReturnValue(byte[] data, int size) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeByteArray(data);
_data.writeInt(size);
mRemote.transact(Stub.TRANSACTION_onReturnValue, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_onReturnValue = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
/**
	 *接收打印机返回消息
	 */
public void onReturnValue(byte[] data, int size) throws android.os.RemoteException;
}
