package com.realsun.utils;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.MifareClassic;
import android.widget.Toast;

import com.realsun.webpos.MainActivity;
import com.realsun.webpos.Nfc;
import com.realsun.webpos.NfcsAdapter;
import com.smartdevice.printer.PrinterHelper;
import com.smartdevice.printer.entity.SupermakerBill;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by hantao on 2017/8/28.
 */

public class MifareCard {
    private static String bytesToHexString(byte[] src) {
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

    private static String bytesToHexString2(byte[] src) {

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
    public  static  void getCardGuid(Intent intent,CardGuidNotify cgn)
    {
        boolean auth = false;
        String cardStr="";
        Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);

        MifareClassic mfc = MifareClassic.get(tag);


        try {

            mfc.connect();
            byte[] myNFCID = intent.getByteArrayExtra(NfcAdapter.EXTRA_ID);

            int before = (int) Long.parseLong(bytesToHexString(myNFCID), 16);

            int r24 = before >> 24 & 0x000000FF;
            int r8 = before >> 8 & 0x0000FF00;
            int l8 = before << 8 & 0x00FF0000;
            int l24 = before << 24 & 0xFF000000;
            long cardno=Long.parseLong(
                    Integer.toHexString((r24 | r8 | l8 | l24)), 16);
            cgn.getCardGuid(cardno);
        } catch (Exception e) {
            e.printStackTrace();
            cgn.getCardGuid(0);
        } finally {
            try {
                if (mfc != null) {
                    mfc.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                cgn.getCardGuid(0);
            }
        }

    }
    public  static void cardIncoming(Intent intent){
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
}
