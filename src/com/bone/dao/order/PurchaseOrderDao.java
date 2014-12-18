package com.bone.dao.order;


import java.util.List;

import com.bone.dao.common.DomainObjectDao;
import com.bone.domain.order.PurchaseOrder;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository(value = "purchaseOrderDao")
public class PurchaseOrderDao extends DomainObjectDao<PurchaseOrder>{
	
	public PurchaseOrderDao(){
		super();
	}
	
//    public PurchaseOrder get(int uesrId) {
//        return getHibernateTemplate().get(PurchaseOrder.class, uesrId);
//    }
    
//    public List<PurchaseOrder> findByEmail(String email) {
//        return (List<PurchaseOrder>) getHibernateTemplate().find("from User u where u.email = ?", email);
//    }
//    
//    public List<User> findByNickName(String nickName) {
//        return (List<User>) getHibernateTemplate().find("from User u where u.nickName = ?", nickName);
//    }
//    
//	public List<User> findBy(String userName, String password) {
//		 return (List<User>) getHibernateTemplate().find("from User u where u.email = ? and u.password = ?", userName,password );
//	}
//	
	public List<PurchaseOrder> find(){
		 return (List<PurchaseOrder>) getHibernateTemplate().find("from PurchaseOrder u");
	}
//	
//	public int findCountGotTalentUser(){
//		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
//		StringBuffer sb = new StringBuffer();
//		sb.append(" select count(u.id)");
//		sb.append(" from users u where u.gotTalent = 1");
//		SQLQuery query = session.createSQLQuery(sb.toString());
//		List<BigInteger> count = query.list();
//		return count.get(0).intValue();
//	}
//	
//	public List<User> findGotTalentUser(int startIndex, int countPerPage){
//		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
//		final String hql = " from User u where u.gotTalent =:gotTalent order by u.id"; //User是类名       
//        final Query query = session.createQuery(hql); 
//        query.setBoolean("gotTalent", true);
//        query.setFirstResult(startIndex); //从第0条开始       
//        query.setMaxResults(countPerPage); //取出10条   
//		return query.list();
//	}
	
}
