package com.bone.assemble.order;

import java.math.BigDecimal;

import com.bone.domain.order.CollectionMoneyRecord;
import com.bone.domain.order.PurchaseOrder;
import com.bone.tools.DateHelper;
import com.bone.web.controller.CollectionMoneyCommitInfo;

public class CollectionMoneyRecordAssemble {
	public static CollectionMoneyRecord create(CollectionMoneyCommitInfo collectionMoneyCommitInfo,
			PurchaseOrder purchaseOrder){
		return new CollectionMoneyRecord(purchaseOrder, 
				DateHelper.toCalendar(collectionMoneyCommitInfo.getCollectionTime()), new BigDecimal(collectionMoneyCommitInfo.getMoney()), collectionMoneyCommitInfo.getRemark());
	}
}
