package com.bone.web.controller;


public class PurchaseOrderDispalyInfo {
	
	private String customer;
	
	private String modelNo;
	
	private String quantity;
	
	private String price;
	
	private String amount;
	
	private String currency;
	
	private String purchasePrice;
	
	private String purchaseAmount;
	
	private String money;
	
	private String profit;
	
	protected PurchaseOrderDispalyInfo(){}
	
	public PurchaseOrderDispalyInfo(String customer, String modelNo,
			String quantity, String price, String amount, String currency,
			String purchasePrice, String purchaseAmount, String money,
			String profit) {
		super();
		this.customer = customer;
		this.modelNo = modelNo;
		this.quantity = quantity;
		this.price = price;
		this.amount = amount;
		this.currency = currency;
		this.purchasePrice = purchasePrice;
		this.purchaseAmount = purchaseAmount;
		this.money = money;
		this.profit = profit;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public String getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(String purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getProfit() {
		return profit;
	}

	public void setProfit(String profit) {
		this.profit = profit;
	}
	
}


