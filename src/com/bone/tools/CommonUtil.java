package com.bone.tools;

public class CommonUtil {

	public static boolean isEmpty(String param){
		if(param == null) return true;
		if(param.length() == 0) return true;
		if(param.trim().length() == 0) return true;
		return false;
	}
	
}
