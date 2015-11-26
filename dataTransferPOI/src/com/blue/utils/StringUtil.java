package com.blue.utils;

/**
 * util class to support string handling
 * Created by applec on 15/11/26.
 */
public class StringUtil {
	private StringUtil(){

	}
	public static boolean nullCheckedStartWith(String s, String target){
		return s != null && s.startsWith(target);
	}
	public static boolean nullCheckedContains(String s, String target){
		return s != null && s.contains(target);
	}
	public static boolean isNullOrEmtpy(String s){
		return s==null || s.equals("");
	}

}
