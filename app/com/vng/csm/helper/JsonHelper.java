package com.vng.csm.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonHelper {

	public static JSONArray listHashMapToJsonArray(List<HashMap<String, String>> list)
	{
		JSONArray json_arr = new JSONArray();
		for (HashMap<String, String> map : list) {
			JSONObject json_obj = new JSONObject(map);
			json_arr.put(json_obj);
		}
		return json_arr;
	}

	public static String listHashMapToJsonString(List<HashMap<String, String>> list)
	{
		JSONArray json_arr = new JSONArray();
		for (HashMap<String, String> map : list) {
			JSONObject json_obj = new JSONObject(map);
			json_arr.put(json_obj);
		}
		return json_arr.toString();
	}

	public static HashMap<String, String> jsonStringToHashMap(String json) {

		HashMap<String, String> hashMap = new HashMap<String, String>();

		ObjectMapper mapper = new ObjectMapper();
		try {
			hashMap = mapper.readValue(json,
					new TypeReference<HashMap<String, String>>() {
					});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return hashMap;
	}

	public static List<HashMap<String, String>> jsonStringToListHashMap(String json) {

		List<HashMap<String, String>> hashMapList = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			hashMapList = mapper.readValue(json,
					new TypeReference<List<HashMap<String, String>>>() {
					});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return hashMapList;
	}
	
}
