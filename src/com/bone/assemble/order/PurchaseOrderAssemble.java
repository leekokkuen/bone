package com.bone.assemble.order;

import java.math.BigDecimal;

import com.bone.domain.order.PurchaseOrder;
import com.bone.web.controller.PurchaseOrderCommitInfo;

public class PurchaseOrderAssemble {
	
	public static PurchaseOrder create(PurchaseOrderCommitInfo purchaseOrderCommitInfo){
		return new PurchaseOrder("测试单", purchaseOrderCommitInfo.getCustomer(), 
				purchaseOrderCommitInfo.getModelNo(), new BigDecimal(purchaseOrderCommitInfo.getQuantity()), 
				new BigDecimal(purchaseOrderCommitInfo.getPrice()),new BigDecimal(purchaseOrderCommitInfo.getAmount()),
				purchaseOrderCommitInfo.getCurrency(),new BigDecimal(purchaseOrderCommitInfo.getPurchasePrice()),
				new BigDecimal(purchaseOrderCommitInfo.getPurchaseAmount()),new BigDecimal(purchaseOrderCommitInfo.getMoney()),
				purchaseOrderCommitInfo.getProfit());
	}
}
