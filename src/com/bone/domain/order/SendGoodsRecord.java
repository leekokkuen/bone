package com.bone.domain.order;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bone.domain.common.DomainObject;


@Entity
@Table(name = "sendGoodsRecords")
public class SendGoodsRecord extends DomainObject {
	
	private PurchaseOrder purchaseOrder;
	
	private Calendar sendTime;
	
	private String sendCode;
	
	private String remark;

	public SendGoodsRecord() {
		super("");
	}

	public SendGoodsRecord(PurchaseOrder purchaseOrder, Calendar sendTime,
			String sendCode, String remark) {
		super("发货单");
		this.purchaseOrder = purchaseOrder;
		this.sendTime = sendTime;
		this.sendCode = sendCode;
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

	public Calendar getSendTime() {
		return sendTime;
	}

	public void setSendTime(Calendar sendTime) {
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
