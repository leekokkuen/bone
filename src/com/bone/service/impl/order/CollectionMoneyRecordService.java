package com.bone.service.impl.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bone.dao.order.CollectionMoneyRecordDao;
import com.bone.dao.order.SendGoodsRecordDao;
import com.bone.domain.order.CollectionMoneyRecord;
import com.bone.service.impl.common.DomainObjectService;
import com.bone.service.order.ICollectionMoneyRecordService;

@Service
public class CollectionMoneyRecordService extends DomainObjectService implements ICollectionMoneyRecordService{
	
	@Autowired
	private CollectionMoneyRecordDao collectionMoneyRecordDao;
	
	public List<CollectionMoneyRecord> findByPurchaseOrderCode(String purchaseOrderCode){
		return collectionMoneyRecordDao.findByPurchaseOrderCode(purchaseOrderCode);
	}
}
