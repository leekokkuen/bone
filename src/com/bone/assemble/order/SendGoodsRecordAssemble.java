package com.bone.assemble.order;

import com.bone.domain.order.PurchaseOrder;
import com.bone.domain.order.SendGoodsRecord;
import com.bone.tools.DateHelper;
import com.bone.web.controller.SendGoodsCommitInfo;

public class SendGoodsRecordAssemble {
	public static SendGoodsRecord create(SendGoodsCommitInfo sendGoodsCommitInfo,
			PurchaseOrder purchaseOrder){
		return new SendGoodsRecord(purchaseOrder, 
				DateHelper.toCalendar(sendGoodsCommitInfo.getSendTime()), sendGoodsCommitInfo.getSendCode(), sendGoodsCommitInfo.getRemark());
	}
}
