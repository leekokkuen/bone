package com.bone.service.impl.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bone.dao.order.SendGoodsRecordDao;
import com.bone.domain.order.SendGoodsRecord;
import com.bone.service.impl.common.DomainObjectService;
import com.bone.service.order.ISendGoodsRecordService;

@Service
public class SendGoodsRecordService extends DomainObjectService implements ISendGoodsRecordService{
	
	@Autowired
	private SendGoodsRecordDao sendGoodsRecordDao;
	
	public List<SendGoodsRecord> findByPurchaseOrderCode(String purchaseOrderCode){
		return sendGoodsRecordDao.findByPurchaseOrderCode(purchaseOrderCode);
	}
}
