package com.bone.web.controller;

public class PurchaseOrderSimpleDisplayInfo {
	
	private String code;
	
	private String customer;
	
	private String modelNo;
	
	private String quantity;
	
	
	public PurchaseOrderSimpleDisplayInfo() {
		super();
	}

	public PurchaseOrderSimpleDisplayInfo(String code, String customer,
			String modelNo, String quantity) {
		super();
		this.code = code;
		this.customer = customer;
		this.modelNo = modelNo;
		this.quantity = quantity;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
