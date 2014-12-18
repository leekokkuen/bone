package com.bone.assemble.order;

import java.util.ArrayList;
import java.util.List;

import com.bone.domain.order.PurchaseOrder;
import com.bone.web.controller.PurchaseOrderSimpleDisplayInfo;

public class PurchaseOrderSimpleDisplayInfoAssemble {
	public static PurchaseOrderSimpleDisplayInfo create(PurchaseOrder purchaseOrder){
		return new PurchaseOrderSimpleDisplayInfo(purchaseOrder.getCode(), 
				purchaseOrder.getCustomer(), purchaseOrder.getModelNo(), purchaseOrder.getQuantity().toString());
	}
	
	public static List<PurchaseOrderSimpleDisplayInfo> create(List<PurchaseOrder> purchaseOrders){
		List<PurchaseOrderSimpleDisplayInfo> purchaseOrderSimpleDisplayInfos = new ArrayList<PurchaseOrderSimpleDisplayInfo>();
		for(PurchaseOrder purchaseOrder:purchaseOrders){
			purchaseOrderSimpleDisplayInfos.add(create(purchaseOrder));
		}
		return purchaseOrderSimpleDisplayInfos;
	}
}
