package com.bone.service.order;

import java.util.List;

import com.bone.domain.order.PurchaseOrder;
import com.bone.domain.user.User;
import com.bone.service.common.IDomainObjectService;

public interface IPurchaseOrderService extends IDomainObjectService{
	
	 //User findUserByUserName(String email);
	
	 List<PurchaseOrder> find();
	 
	 PurchaseOrder find(String code);
}
