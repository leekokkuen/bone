package com.bone.dao.common;
import java.lang.reflect.ParameterizedType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import java.lang.reflect.Type;
import java.util.List;

import static java.text.MessageFormat.format;

import com.bone.domain.common.DomainObject;
import com.bone.tools.CollectionUtil;

@Repository(value = "domainObjectDao")
public class DomainObjectDao<T extends DomainObject> extends BaseDao<DomainObject>{
	
	private Class<T> entityClass;
    @Autowired
    private HibernateTemplate hibernateTemplate;
    
    @Autowired
    protected DataFieldMaxValueIncrementer idGenarater;
    
    protected final String className;
	protected final Class<T> clazz;

	public DomainObjectDao() {
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
	    Type type = parameterizedType.getActualTypeArguments()[0];
	    if(type instanceof ParameterizedType) {
	        type = ((ParameterizedType) type).getRawType();
	    }
	    this.clazz = (Class<T>) type;
	    this.className = this.clazz.getSimpleName();
	}
	
	public Long getNextId(){
		return idGenarater.nextLongValue();
	}
	
    public void persist(T t) {
    	Long id = 0L;
    	if(t.getId()==null){
    		t.setId(id=idGenarater.nextLongValue());
    	}
    	if(t.getCode()==null){
    		t.setCode(String.valueOf(id));
    	}
    	hibernateTemplate.persist(t);
    }

	/**
	 * @return the idGenarater
	 */
	public DataFieldMaxValueIncrementer getIdGenarater() {
		return idGenarater;
	}
    
//    public void add(T domainObject) {
//    	Long id = 0L;
//    	if(domainObject.getId()==null){
//    		domainObject.setId(id=idGenarater.nextLongValue());
//    	}
//    	if(domainObject.getCode()==null){
//    		domainObject.setCode(String.valueOf(id));
//    	}
//        getHibernateTemplate().save(domainObject);
//    }
    
	public <X extends T> X findByCode(String code){
        final String hql = format("FROM {0} o WHERE o.code = ?", clazz.getName());
        List<X> list = getHibernateTemplate().find(hql,code);
        if(CollectionUtil.isNotNil(list)){
			return list.get(0);
		}
		return null;
    }
	
	public <X extends T> X findByName(String name){
        final String hql = format("FROM {0} o WHERE o.name = ?", clazz.getName());
        List<X> list = getHibernateTemplate().find(hql,name);
        if(CollectionUtil.isNotNil(list)){
			return list.get(0);
		}
		return null;
    }
}
