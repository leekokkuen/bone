package com.bone.service.impl.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bone.dao.user.UserDao;
import com.bone.domain.user.User;
import com.bone.service.impl.common.DomainObjectService;
import com.bone.service.user.IUserService;



@Service
public class UserService extends DomainObjectService implements IUserService{

    @Autowired
    private UserDao userDao;
    
    @Override
	public User findUserByUserName(String name){
		User users =  userDao.findByName(name);
		return users;
	}
    
    @Override
	public boolean cheakPassword(String name,String password){
		User user =  userDao.findByName(name);
		if(user==null){
			return false;
		}
		return user.getPassword().equals(password);
	}

}
