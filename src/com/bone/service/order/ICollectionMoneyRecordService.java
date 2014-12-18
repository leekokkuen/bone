package com.bone.service.order;

import java.util.List;

import com.bone.domain.order.CollectionMoneyRecord;

public interface ICollectionMoneyRecordService {
	
	List<CollectionMoneyRecord> findByPurchaseOrderCode(String purchaseOrderCode);
}
