package com.bone.domain.order;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bone.domain.common.DomainObject;


@Entity
@Table(name = "collectionMoneyRecords")
public class CollectionMoneyRecord extends DomainObject {
	
	private PurchaseOrder purchaseOrder;
	
	private Calendar collectionTime;
	
	private BigDecimal money;
	
	private String remark;

	public CollectionMoneyRecord() {
		super("");
	}

	public CollectionMoneyRecord(PurchaseOrder purchaseOrder,
			Calendar collectionTime, BigDecimal money, String remark) {
		super("收款单");
		this.purchaseOrder = purchaseOrder;
		this.collectionTime = collectionTime;
		this.money = money;
		this.remark = remark;
	}

	@ManyToOne()
	@JoinColumn(name = "purchaseOrderId", referencedColumnName = "id")
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public Calendar getCollectionTime() {
		return collectionTime;
	}

	public void setCollectionTime(Calendar collectionTime) {
		this.collectionTime = collectionTime;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
