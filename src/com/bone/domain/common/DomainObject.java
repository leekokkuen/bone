package com.bone.domain.common;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;



import com.bone.tools.DateHelper;

@MappedSuperclass
public abstract class DomainObject {
	
	private Long id;

	private Integer version;

	private String code;

	private String name;

	private Calendar createTime;
	
	private Calendar endTime;
	
	private String description;
		
	protected DomainObject() {}
		
	public DomainObject(String code, String name, String description) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
		this.version = 1;
		this.createTime = Calendar.getInstance();
		this.endTime = Calendar.getInstance();
	}
	
	public DomainObject(String name) {
		super();
		this.name = name;
		this.version = 1;
		this.createTime = DateHelper.getCurrentDateTime();
		this.endTime = DateHelper.getMax();
	}
	
	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getEndTime() {
		return endTime;
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}
	
}
