package com.bone.dao.order;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bone.dao.common.DomainObjectDao;
import com.bone.domain.order.CollectionMoneyRecord;

@Repository(value = "collectionMoneyRecordDao")
public class CollectionMoneyRecordDao extends DomainObjectDao<CollectionMoneyRecord>{
	
	public List<CollectionMoneyRecord> findByPurchaseOrderCode(String purchaseOrderCode){
		List<CollectionMoneyRecord> collectionMoneyRecords 
			= getHibernateTemplate().find("from CollectionMoneyRecord c where c.purchaseOrder.code = ? ", purchaseOrderCode );
		return collectionMoneyRecords;
	}
}
