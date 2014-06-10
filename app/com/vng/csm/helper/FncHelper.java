package com.vng.csm.helper;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;


import org.json.JSONArray;
import org.json.JSONObject;


import com.twmacinta.util.MD5;

public class FncHelper {

	public static String  numberFormat(String number){
        DecimalFormat df = new DecimalFormat("###,###,###,###,###,###");       
		return df.format(Double.valueOf(number));
	}
	
	public static String md5(String value){
		 MD5 md5 = new MD5();	
		 md5.Update(value);
		 return md5.asHex().toString();
	}
	
	public static JSONArray listHashMapToJsonArray(List<HashMap<String, String>> list)
	{       
	    JSONArray json_arr=new JSONArray();
	    for (HashMap<String, String> map : list) {
	        JSONObject json_obj=new JSONObject(map);
	        json_arr.put(json_obj);
	    }
	    return json_arr;
	}
	
	public static String listHashMapToJsonString(List<HashMap<String, String>> list)
	{       
	    JSONArray json_arr=new JSONArray();
	    for (HashMap<String, String> map : list) {
	        JSONObject json_obj=new JSONObject(map);
	        json_arr.put(json_obj);
	    }
	    return json_arr.toString();
	}
	
	
}
