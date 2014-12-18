package com.bone.web.controller;

public class JsonResultInfo {
	private int code;
	private String errorMsg;
	private Object data;
	public JsonResultInfo(){
		super();
		this.code = 0;
		this.errorMsg = "";
		this.data = "";
	}
	
	public JsonResultInfo(int code, String errorMsg) {
		super();
		this.code = code;
		this.errorMsg = errorMsg;
		this.data = "";
	}
	
	public JsonResultInfo(int code, String errorMsg, Object data) {
		super();
		this.code = code;
		this.errorMsg = errorMsg;
		this.data = data;
	}
	
	public JsonResultInfo(Object data) {
		super();
		this.code = 0;
		this.errorMsg = "";
		this.data = data;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	  
	
}
