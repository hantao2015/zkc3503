package com.smartdevice.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/4/1.
 */
public class PatternMatcher {
    public static String SHOP_NAME = "[[ #{����}]]";
    public static String CASHIER_NAME = "#{����Ա����}";
    public static String TABLE_NAME = "#{�ƺ�}";
    public static String ORDER_NAME = "#{���ݺ�}";
    public static String ORDER_TIME = "#{�µ�ʱ��}";
    public static String TOTAL_PRICE = "#{�ܼ�}";
    public static String CAN_RECEIVER = "#{Ӧ��}";
    public static String REAL_RECEIVER = "#{ʵ��}";
    public static String TOTAL_COUNT = "#{����}";
    public static String PAY = "#{֧����ʽ}";
    public static String CHARGE = "#{����}";
    public static String VIP_NAME = "#{��Ա����}";
    public static String VIP_NUMBER = "#{��Ա��}";
    public static String BLANCE = "#{���}";
    public static String INTEGRAL = "#{����}";
    public static String SHOP_ADDRESS = "#{��ַ}";
    public static String ITEM = "#item";
    public static String GOODS_NAME = "#{��Ʒ����}";
    public static String UNIT_PRICE = "#{����}";
    public static String GOODS_COUNT = "#{����}";
    public static String SUB_TOTAL = "#{С��}";


    public static boolean replaceString(String pattern, String OriginalStr){
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(OriginalStr);
        return m.find();
    }
}
