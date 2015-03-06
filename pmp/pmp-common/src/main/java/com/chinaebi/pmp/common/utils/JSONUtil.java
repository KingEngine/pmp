package com.chinaebi.pmp.common.utils;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class JSONUtil{
	
	public static <T> List<T> generateListFromJson(String json,T t){
		JSONArray jsonList = JSONArray.fromObject(json);
		List<T> list = new ArrayList<T>();
		for (int i = 0; i < jsonList.size(); i++) {
			JSONObject object = (JSONObject) jsonList.get(i);
			T result = (T) JSONObject.toBean(object,t.getClass());
			if(null!=t){
				list.add(t);
			}
		}
		return list;
	}

}
