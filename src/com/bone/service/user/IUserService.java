package com.bone.service.user;

import java.util.List;

import com.bone.domain.user.User;
import com.bone.service.common.IDomainObjectService;

public interface IUserService extends IDomainObjectService{
	
	 User findUserByUserName(String email);
	
	 boolean cheakPassword(String name,String password);
}
