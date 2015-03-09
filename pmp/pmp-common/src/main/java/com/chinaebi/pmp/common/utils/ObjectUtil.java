package com.chinaebi.pmp.common.utils;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ObjectUtil {
	
	public static Map<String,Object>  beanToMap(Object object){
		
		Class<? extends Object> clazz = object.getClass();
		
		Map<String,Object> map = new HashMap<String, Object>();
		//得到属性域
		Field[] fields = clazz.getDeclaredFields();
		
		for(Field field:fields){
			
			String fieldName = field.getName();
			
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			
			String getMethodName = "get" + firstLetter + fieldName.substring(1);
			
			try {
				Method getMethod = clazz.getMethod(getMethodName, new Class[] {});
				Object value = getMethod.invoke(object, new Object[] {});
				map.put(fieldName, value);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
}
