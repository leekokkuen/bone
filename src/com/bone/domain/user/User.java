package com.bone.domain.user;

import java.util.Calendar;

import com.bone.domain.common.DomainObject;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends DomainObject{	
	/**
	 * 账号
	 */
	private String email;
	
	private String password;
	
	
	
	protected User(){}
	
	public User(String name,String password) {
		super(name);
		this.password = password;
	}
	


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
