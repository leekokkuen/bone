package com.bone.domain.order;

import java.math.BigDecimal;
import java.util.Calendar;

import com.bone.domain.common.DomainObject;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "purchaseorders")
public class PurchaseOrder extends DomainObject{
	
	private String customer;
	
	private String modelNo;
	
	private BigDecimal quantity;
	
	private BigDecimal price;
	
	private BigDecimal amount;
	
	private String currency;
	
	private BigDecimal purchasePrice;
	
	private BigDecimal purchaseAmount;
	
	private BigDecimal money;
	
	private String profit;
	
	protected PurchaseOrder(){}
	
	public PurchaseOrder(String name) {
		super(name);
	}
	
	public PurchaseOrder(String name, String customer, String modelNo, BigDecimal quantity,
			BigDecimal price, BigDecimal amount, String currency,
			BigDecimal purchasePrice, BigDecimal purchaseAmount,
			BigDecimal money, String profit) {
		super(name);
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

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public BigDecimal getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(BigDecimal purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getProfit() {
		return profit;
	}

	public void setProfit(String profit) {
		this.profit = profit;
	}
	
	
}
