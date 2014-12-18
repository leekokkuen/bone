package com.bone.tools;

import java.io.File;

import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.wheresports.tool.WheresportsToQiniuTool;


public class QiNiuTool {
	
	public static String getUptoken() {
		String accessKey = "2NvH9s4vV3j-5M1qPvTAy-99HKtr7QeMPVNU4nNs";
		String secretKey = "oCZYSvrsXVK-6Tg1vnJUNjrNM9JN0Of5IQJUeHSo";
		String bucketName = "leekokkuenspace";
		String callbackUrl = "http://www.nalidong.com:8081/doit/mobile/user/getHeadShowInfo4Qiniu.mobile";
		String callbackBody = "name=$(fname)&hash=$(etag)&userCode=$(x:userCode)&typeId=$(x:typeId)&key=$(key)&bucket=$(bucket)";	
		try {
			WheresportsToQiniuTool tool = new WheresportsToQiniuTool(accessKey, secretKey);
			return tool.getUptoken(bucketName,callbackUrl,callbackBody);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		String token = getUptoken();
		PutExtra extra = new PutExtra();
        String key = "abc324233454454545";
        File localFile = new File("D://0860100053.jpg");
        PutRet ret = IoApi.putFile(token, key, localFile, extra);
	}
	
}
