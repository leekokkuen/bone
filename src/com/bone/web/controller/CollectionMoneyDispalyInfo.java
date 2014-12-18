package com.bone.web.controller;

public class CollectionMoneyDispalyInfo{
	
	private String purchaseOrderId;
	
	private String collectionTime;
	
	private String money;
	
	private String remark;
	
	public CollectionMoneyDispalyInfo() {
		super();
	}
	
	public CollectionMoneyDispalyInfo(String purchaseOrderId,
			String collectionTime, String money, String remark) {
		super();
		this.purchaseOrderId = purchaseOrderId;
		this.collectionTime = collectionTime;
		this.money = money;
		this.remark = remark;
	}

	public String getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(String purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public String getCollectionTime() {
		return collectionTime;
	}

	public void setCollectionTime(String collectionTime) {
		this.collectionTime = collectionTime;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	
}
