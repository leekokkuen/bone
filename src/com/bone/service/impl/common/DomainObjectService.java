package com.bone.service.impl.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bone.dao.common.DomainObjectDao;
import com.bone.domain.common.DomainObject;
import com.bone.service.common.IDomainObjectService;

//@Transactional
@Service
public class DomainObjectService implements IDomainObjectService{

	@Autowired
	private DomainObjectDao domainObjectDao;
	 
	
//    @Transactional(rollbackForClassName={"Exception"})
	public String persist(DomainObject domainObject){
		domainObjectDao.persist(domainObject);
		return domainObject.getCode();
	}

	@Override
	public void delete(DomainObject domainObject) {
		domainObjectDao.delete(domainObject);
	}

	@Override
	public void update(DomainObject domainObject) {
		domainObjectDao.update(domainObject);
	}

	public DomainObjectDao getDomainObjectDao() {
		return domainObjectDao;
	}

	public void setDomainObjectDao(DomainObjectDao domainObjectDao) {
		this.domainObjectDao = domainObjectDao;
	}
	
	public Long getNextId(){
		return domainObjectDao.getNextId();
	}
}
