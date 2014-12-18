package com.bone.service.order;

import java.util.List;

import com.bone.domain.order.SendGoodsRecord;

public interface ISendGoodsRecordService {
	
	List<SendGoodsRecord> findByPurchaseOrderCode(String purchaseOrderCode);
}
