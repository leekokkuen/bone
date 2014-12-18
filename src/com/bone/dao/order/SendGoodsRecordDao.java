package com.bone.dao.order;


import java.util.List;

import com.bone.dao.common.DomainObjectDao;
import com.bone.domain.order.SendGoodsRecord;

import org.springframework.stereotype.Repository;

@Repository(value = "sendGoodsRecordDao")
public class SendGoodsRecordDao extends DomainObjectDao<SendGoodsRecord>{
	
	public List<SendGoodsRecordDao> find(){
		 return (List<SendGoodsRecordDao>) getHibernateTemplate().find("from PurchaseOrder u");
	}

	public List<SendGoodsRecord> findByPurchaseOrderCode(String purchaseOrderCode){
		List<SendGoodsRecord> sendGoodsRecords 
			= getHibernateTemplate().find("from SendGoodsRecord s where s.purchaseOrder.code = ? ", purchaseOrderCode );
		return sendGoodsRecords;
	}
}
