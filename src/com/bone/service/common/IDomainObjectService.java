package com.bone.service.common;

import com.bone.domain.common.DomainObject;

public interface IDomainObjectService {
	
	public String persist(DomainObject domainObject) throws Exception;
	
	public void delete(DomainObject domainObject);
	
	public void update(DomainObject domainObject);
	
	public Long getNextId();
}
