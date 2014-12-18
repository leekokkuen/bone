package com.bone.assemble.order;

import com.bone.domain.order.PurchaseOrder;
import com.bone.web.controller.PurchaseOrderDispalyInfo;

public class PurchaseOrderDispalyInfoAssemble {
	 public static PurchaseOrderDispalyInfo create(PurchaseOrder purchaseOrder){
		 return new PurchaseOrderDispalyInfo(purchaseOrder.getCustomer(), purchaseOrder.getModelNo(), purchaseOrder.getQuantity().toString(), 
				 purchaseOrder.getPrice().toString(),purchaseOrder.getAmount().toString(), 
				 purchaseOrder.getCurrency(),purchaseOrder.getPurchasePrice().toString(),purchaseOrder.getPurchaseAmount().toString(),
				 purchaseOrder.getMoney().toString(),purchaseOrder.getProfit());
	 }
}
