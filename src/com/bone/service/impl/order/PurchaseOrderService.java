package com.bone.service.impl.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bone.dao.order.PurchaseOrderDao;
import com.bone.dao.user.UserDao;
import com.bone.domain.order.PurchaseOrder;
import com.bone.service.impl.common.DomainObjectService;
import com.bone.service.order.IPurchaseOrderService;



@Service
public class PurchaseOrderService extends DomainObjectService implements IPurchaseOrderService{

    @Autowired
    private PurchaseOrderDao purchaseOrderDao;
    
    public List<PurchaseOrder> find(){
    	return purchaseOrderDao.find();
    }
    
    public PurchaseOrder find(String code){
    	return purchaseOrderDao.findByCode(code);
    }
//    @Override
//	public User findUserByUserName(String email) {
//		User users =  userDao.findByName(email);
//		return users;
//	}

}
