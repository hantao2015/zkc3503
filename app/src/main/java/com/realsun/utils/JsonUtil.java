package com.realsun.utils;
 

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Created by fzhang on 2016/11/18.
 */

public class JsonUtil {

    /**
     * ��java beanʵ������ת��ΪJSon�ַ���
     *
     * @return ת������ַ���
     */
	
	  public static  Object fromJsonToJava(JSONObject json,Class pojo) throws Exception{  
        // ���ȵõ�pojo��������ֶ�  
        Field [] fields = pojo.getDeclaredFields();  
        // ���ݴ����Class��̬����pojo����  
        Object obj = pojo.newInstance();  
        for(Field field: fields){  
            // �����ֶοɷ��ʣ����룬���򱨴�  
            field.setAccessible(true);  
            // �õ��ֶε�������  
            String name = field.getName();  
            // ��һ�ε�����������ֶ���JSONObject�в����ڻ��׳��쳣��������쳣����������  
            try{  
                    json.get(name);  
            }catch(Exception ex){  
                continue;  
            }  
            if(json.get(name) != null && !"".equals(json.getString(name))){  
                // �����ֶε����ͽ�ֵת��Ϊ��Ӧ�����ͣ������õ����ɵĶ����С�  
                if(field.getType().equals(Long.class) || field.getType().equals(long.class)){  
                    field.set(obj, Long.parseLong(json.getString(name)));  
                }else if(field.getType().equals(String.class)){  
                    field.set(obj, json.getString(name));  
                } else if(field.getType().equals(Double.class) || field.getType().equals(double.class)){  
                    field.set(obj, Double.parseDouble(json.getString(name)));  
                } else if(field.getType().equals(Integer.class) || field.getType().equals(int.class)){  
                    field.set(obj, Integer.parseInt(json.getString(name)));  
                } else if(field.getType().equals(java.util.Date.class)){  
                    field.set(obj, Date.parse(json.getString(name)));  
                }else{  
                    continue;  
                }  
            }  
        }  
        return obj;  
    }  
    public static String obj2json(Object obj) {
        Class objClazz = obj.getClass();
//        Log.i("ZF", objClazz.getName());
        if (obj instanceof String) {                                    //�ַ�������
            return "\"" + obj.toString() + "\"";
        } else if (obj instanceof Character) {                          //�ַ���
           // return "\"" + String.valueOf(( ) obj) + "\"";
        	  return "\"" +     "\"";
        } else if (obj instanceof Byte) {                               //byte��
           // return ((byte) obj & 0xff) + "";
        } else if (obj instanceof Short) {                              //short��
            return ((Short) obj) + "";
        } else if (obj instanceof Integer) {                            //����
            return ((Integer) obj) + "";
        } else if (obj instanceof Long) {                               //������
            return ((Long) obj) + "";
        } else if (obj instanceof Date) {                               //������
            return date2json((Date) obj);
        } else if (obj instanceof Float) {                              //������
            //return (float) obj + "";
        	  return "\"" +     "\"";
        } else if (obj instanceof Double) {                             //˫���ȸ�����
           // return (double) obj + "";
        	  return "\"" +     "\"";
        } else if (obj instanceof Boolean) {                            //������
           // return (boolean) obj ? "true" : "false";
        	  return "\"" +     "\"";
        } else if (obj instanceof Set) {                                //Set��
            return set2json((Set) obj);
        } else if (obj instanceof List) {                               //List��
            return list2json((List) obj);
        } else if (obj instanceof Map) {                                //Map��
            return map2json((Map) obj);
        } else {
            StringBuffer sb = new StringBuffer(); //��ʼ�������ַ���
            sb.append("{");
            int count = 0;
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if ((field.getModifiers() & 8) == 8) continue;         //���еľ�̬�������б���
                if (count != 0) sb.append(",");
                count++;
                sb.append("\"");
                sb.append(field.getName());
                sb.append("\":");
                try {
//                    Log.i("ZF",field.get(obj).getClass().getName() + ":" + field.getModifiers());
                    //�ж����г�Ա���������Ƿ�Ϊ��������
                    if (field.getType().isArray()) {
                        Object o = field.get(obj);
                        if (o == null) {
                            sb.append("[]");
                        } else {
                            //����������ͨ��toBoxArray���������Զ�װ��Ϊָ���İ�װ����,
                            // Ȼ��ͨ��Arrays������ת��ΪListȥ����
                            sb.append(obj2json(Arrays.asList(
                                    toBoxArray(o,field.getType().getComponentType())
                                    )));
                        }
                    } else {
                        //ΪFloat��Double��װ����ʱ �Ҷ���ΪNULLʱ�����쳣�Ĵ���
                        if (field.get(obj) == null && ("java.lang.Double".equals(field.getType()
                                .getName())) ||
                                "java.lang.Float".equals(field.getType().getName())) {
                            sb.append("0");
                        } else {
                            sb.append(obj2json(field.get(obj)));
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            sb.append("}");
            return sb.toString();
        }
		return "";
    }

    /**
     * ��JSon�ַ���ת��Ϊָ����(�ֽ����ļ�)��װ��
     *
     * @param jsonStr ��ת����JSon�ַ���
     * @param clazz   ��ת���İ�װ���Class�ֽ����ļ�
     * @return ���صİ�װ���ʵ������
     */
    public static Object json2obj(String jsonStr, Class clazz) {
        Object rtnObj = null;
//        Log.i("ZF",clazz.getName());
        try {
            //���ȴ��������򲼶��Ͳ��ǰ�װ����,ʹ��newInstanceʱ�����쳣
            if ("boolean".equals(clazz.getName())) {                //boolean
                return "true".equals(jsonStr) ? true : false;
            } else if ("char".equals(clazz.getName()) ||
                    "java.lang.Character".equals(clazz.getName())) {//char
                return removeqm(jsonStr).toCharArray()[0];
            } else if ("byte".equals(clazz.getName()) ||
                    "java.lang.Byte".equals(clazz.getName())) {     //byte
                return (byte) Integer.parseInt(jsonStr);
            } else if ("short".equals(clazz.getName()) ||
                    "java.lang.Short".equals(clazz.getName())) {    //short
                return (Short.parseShort(jsonStr));
            } else if ("float".equals(clazz.getName()) ||
                    "java.lang.Float".equals(clazz.getName())) {    //float
                return Float.parseFloat(jsonStr);
            } else if ("double".equals(clazz.getName()) ||
                    "java.lang.Double".equals(clazz.getName())) {   //double
                return Double.parseDouble(jsonStr);
            } else if ("int".equals(clazz.getName()) ||
                    "java.lang.Integer".equals(clazz.getName())) {  //int
                return Integer.parseInt(jsonStr);
            } else if ("long".equals(clazz.getName()) ||
                    "java.lang.Long".equals(clazz.getName())) {     //Long
                return Long.parseLong(jsonStr);
            }
            rtnObj = clazz.newInstance();                                       //��װ���͵Ĵ���
            if (rtnObj instanceof String) {                                     //�ַ���
                return removeqm(jsonStr);
            } else if (rtnObj instanceof Date) {                                //������
                return json2date(jsonStr);
            } else {                                                            //ʵ�����
                JSONObject jsonObject = new JSONObject(jsonStr);
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    if ((field.getModifiers() & 8) == 8) continue;         //���еľ�̬�������б���
                    //��ȡ�����г�Ա������Json�ַ���
                    String fieldStr = jsonObject.getString(field.getName());
//                    Log.i("ZF", fieldStr + "/" + field.getType().getName());
                    //�ж��Ƿ�Ϊ��������
                    if (field.getType().isArray()) {
                        List list = json2list(new ArrayList(), fieldStr, field.getType()
                                .getComponentType());
//                        field.set(rtnObj, tobytearray(list.toArray()));
                        //ͨ��toAssignArray����ת��ΪĿ���ֽ����ļ�������
                        field.set(rtnObj,toAssignArray(list.toArray(),field.getType().getComponentType()));
                    } else if ("java.util.Map".equals(field.getType().getName()) ||
                            "java.util.HashMap".equals(field.getType().getName()) ||
                            "java.util.LinkedHashMap".equals(field.getType().getName()) ||
                            "java.util.TreeMap".equals(field.getType().getName())) {//�ж��Ƿ�ΪMap
//                        Log.i("ZF", "Here!");
                        Class keyClz = getGenericType(field, 0);
                        Class valClz = getGenericType(field, 1);
                        Map map = (Map) field.get(rtnObj);
                        map = json2map(map, fieldStr, keyClz, valClz);
                    } else if ("java.util.List".equals(field.getType().getName()) ||
                            "java.util.ArrayList".equals(field.getType().getName()) ||
                            "java.util.LinkedList".equals(field.getType().getName())) {
                        Class itmClz = getGenericType(field, 0);
                        List list = (List) field.get(rtnObj);
                        list = json2list(list, fieldStr, itmClz);
                    } else if ("java.util.Set".equals(field.getType().getName()) ||
                            "java.util.HashSet".equals(field.getType().getName()) ||
                            "java.util.LinkedHashSet".equals(field.getType().getName()) ||
                            "java.util.TreeSet".equals(field.getType().getName())) {
                        Class itmClz = getGenericType(field, 0);
                        Set set = (Set) field.get(rtnObj);
                        set = json2set(set, fieldStr, itmClz);
                    } else {
                        field.set(rtnObj, json2obj(fieldStr, field.getType()));
                    }
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rtnObj;
    }

    private static Date json2date(String jsonStr) {
        Map<String, Long> mapDate = json2map(new HashMap(), jsonStr, String.class, Long.class);
        Date dd = new Date(mapDate.get("time"));
        return dd;
    }

    /**
     * ��dateתjson�ַ���
     *
     * @param dd ��ת����Dateʵ������
     * @return ת�����JSon�ַ���
     */
    private static String date2json(Date dd) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dd);
//        Log.i("ZF",calendar.toString());
        Map<String, Long> map = new LinkedHashMap<String, Long>();
        map.put("date", Long.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
        map.put("day", Long.valueOf(calendar.get(Calendar.DAY_OF_WEEK) - 1));
        map.put("hours", Long.valueOf(calendar.get(Calendar.HOUR)));
        map.put("minutes", Long.valueOf(calendar.get(Calendar.MINUTE)));
        map.put("month", Long.valueOf(calendar.get(Calendar.MONTH)));
        map.put("seconds", Long.valueOf(calendar.get(Calendar.SECOND)));
        map.put("time", dd.getTime());
        map.put("timezoneOffset", (long) 0 - (calendar.get(Calendar.ZONE_OFFSET) * 60 / (3600 *
                1000)));
        map.put("year", Long.valueOf(calendar.get(Calendar.YEAR) - 1900));
        return map2json(map);
    }

    /**
     * Set תjson�ַ���
     *
     * @param set ��ת����Setʵ������
     * @return ת�����JSon�ַ���
     */
    private static String set2json(Set set) {
        if (set.size() > 0) {
            StringBuffer sb = new StringBuffer();
            sb.append("[");
            int count = 1;
            for (Iterator it = set.iterator(); it.hasNext(); ) {
                Object obj = it.next();
                sb.append(obj2json(obj));
                if (count != set.size()) sb.append(",");
                count++;
            }
            sb.append("]");
            return sb.toString();
        } else {
            return "";
        }
    }

    /**
     * List תjson�ַ���
     *
     * @param list ��ת����Listʵ������
     * @return ת�����JSon�ַ���
     */
    private static String list2json(List list) {
        if (list.size() > 0) {
            StringBuffer sb = new StringBuffer();
            sb.append("[");
            int count = 1;
            for (Iterator it = list.iterator(); it.hasNext(); ) {
                Object obj = it.next();
                sb.append(obj2json(obj));
                if (count != list.size()) sb.append(",");
                count++;
            }
            sb.append("]");
            return sb.toString();
        } else {
            return "";
        }
    }

    /**
     * Map תjson�ַ���
     *
     * @param map ��ת����mapʵ������
     * @return ת�����JSon�ַ���
     */
    private static String map2json(Map map) {
        if (map.size() > 0) {
            StringBuffer sb = new StringBuffer();
            sb.append("{");
            int count = 1;
            for (Object obj : map.keySet()) {
                sb.append(obj2json(obj));
                sb.append(":");
                sb.append(obj2json(map.get(obj)));
                if (count != map.size()) sb.append(",");
                count++;
            }
            sb.append("}");
            return sb.toString();
        } else {
            return "";
        }
    }

    /**
     * JSon�ַ���תMap�ľ�̬����
     *
     * @param inputMap ����Map
     * @param jsonStr  ת��JSon�ַ���
     * @param keyClz   Map�ļ�ʵ��������ֽ����ļ�
     * @param valClz   Map��ֵʵ��������ֽ����ļ�
     * @return
     */
    private static Map json2map(Map inputMap, String jsonStr, Class keyClz, Class valClz) {
//        Log.i("ZF",jsonStr);
        JSONObject jsonObject = null;
        Map rtnMap = inputMap;
        try {
            jsonObject = new JSONObject(jsonStr);
            for (Iterator it = jsonObject.keys(); it.hasNext(); ) {
                Object keyObj = it.next();
                Object valObj = jsonObject.getString(keyObj.toString());
                keyObj = json2obj(keyObj.toString(), keyClz);
//                Log.i("ZF",keyObj.toString() + ":" + valObj.toString());
                valObj = json2obj(valObj.toString(), valClz);
                rtnMap.put(keyObj, valObj);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return rtnMap;
    }

    /**
     * JSon�ַ���תSet�ľ�̬����
     *
     * @param inputSet �����Set
     * @param jsonStr  ת��JSon�ַ���
     * @param itmClz   Set�ڵ��Class�ֽ����ļ�
     * @return
     */
    private static Set json2set(Set inputSet, String jsonStr, Class itmClz) {
        Set rtnSet = inputSet;
        try {
            JSONArray jsonArray = new JSONArray(jsonStr);
            for (int i = 0; i < jsonArray.length(); i++) {
                String itmStr = (String) jsonArray.get(i);
                Object itmObj = json2obj(itmStr, itmClz);
                rtnSet.add(itmObj);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return rtnSet;
    }

    /**
     * JSon�ַ���תList�ľ�̬����
     *
     * @param inputList �����List
     * @param jsonStr   ת��JSon�ַ���
     * @param itmClz    List�ڵ��Class�ֽ����ļ�
     * @return
     */
    private static List json2list(List inputList, String jsonStr, Class itmClz) {
        List rtnList = inputList;
        try {
            JSONArray jsonArray = new JSONArray(jsonStr);
            for (int i = 0; i < jsonArray.length(); i++) {
                String itmStr = jsonArray.get(i) + "";
                Object itmObj = json2obj(itmStr, itmClz);
                rtnList.add(itmObj);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return rtnList;
    }

    /**
     * ��ȡField�е�List,Set,Map�еķ��͵�����
     *
     * @param field ��װ�����еĳ�Ա����Field
     * @param i     ����Map<String,Integer> i=0 ����java.lang.String�ֽ����ļ�
     *              i=1 ����java.lang.Integer�ֽ����ļ�
     * @return ȡ�����ֽ����ļ�
     * @throws RuntimeException
     * @throws ClassNotFoundException
     */
    public static Class getGenericType(Field field, Integer i)
            throws RuntimeException, ClassNotFoundException {
        Type mapMainType = field.getGenericType();

        if (mapMainType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) mapMainType;
            Type[] types = parameterizedType.getActualTypeArguments();
            if (i < types.length) {
                return Class.forName(types[i].toString().replace("class ", ""));
            } else {
                throw new RuntimeException("��ѯ���������鳬���߽�!");
            }
        } else {
            throw new RuntimeException("��ȡ�������ͳ���");
        }
    }

    /**
     * �Ƴ���ĩλ����Quotation Mark
     *
     * @param inputStr
     * @return
     */
    private static String removeqm(String inputStr) {
        StringBuffer sb = new StringBuffer();
        sb.append(inputStr);
        if (sb.length() > 0) {                                          //ȥ����ĩ�������ַ�
            if (sb.charAt(sb.length() - 1) == '\"') {
                sb.deleteCharAt(sb.length() - 1);
            }
            if (sb.charAt(0) == '\"') {
                sb.deleteCharAt(0);
            }
        }
        return sb.toString();
    }

    /**
     * ת��Ϊָ��Class�ֽ��������
     * @param objs
     * @param clazz
     * @return
     */
    private static Object toAssignArray(Object objs,Class clazz) {
        int len = Array.getLength(objs);
        Object array = Array.newInstance(clazz,len);
        for(int i=0;i<len;i++) {
            Array.set(array,i,Array.get(objs,i));
        }
        return array;
    }

    /**
     * װ��Ϊָ���İ�װ����
     * @param objs
     * @param clazz
     * @return
     */
    private static Object[] toBoxArray(Object objs,Class clazz) {
        int len = Array.getLength(objs);
        Object[] outObjs = new Object[len];
        for(int i=0;i<len;i++) {
            Array.set(outObjs,i,(Object) Array.get(objs,i));
        }
        return outObjs;
    }
    
}

