package com.bone.tools;

import org.apache.log4j.Logger;


public class LogUtil {

	public static void d(Class<?> c, String msg, Throwable t){
		Logger.getLogger(c).info(msg, t);
	}
	
	public static void d(Class<?> c, String msg){
		Logger.getLogger(c).info(msg);
	}
	
	public static void e(Class<?> c, String msg, Throwable t){
		Logger.getLogger(c).info(msg, t);
	}
	
	public static void e(Class<?> c, String msg){
		Logger.getLogger(c).info(msg);
	}
	
}
