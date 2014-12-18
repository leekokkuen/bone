package com.bone.web.controller;

public class SendGoodsDispalyInfo{
	
	private String purchaseOrderId;
	
	private String sendTime;
	
	private String sendCode;
	
	private String remark;

	public SendGoodsDispalyInfo() {
		super();
	}

	public SendGoodsDispalyInfo(String purchaseOrderId, String sendTime,
			String sendCode, String remark) {
		super();
		this.purchaseOrderId = purchaseOrderId;
		this.sendTime = sendTime;
		this.sendCode = sendCode;
		this.remark = remark;
	}


	public String getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(String purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getSendCode() {
		return sendCode;
	}

	public void setSendCode(String sendCode) {
		this.sendCode = sendCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	
}
