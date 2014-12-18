package com.bone.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bone.domain.user.User;
import com.bone.service.user.IUserService;

@Controller
@RequestMapping("/login")
public class LoginController{
	/**
	 * 自动注入
	 */
	@Autowired
	private IUserService userService;

	 @RequestMapping("/goLogin.html")
	public String goLogin(){
		return "login";
	}
	/**
	 * 用户登录
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
    @RequestMapping("/doLogin.json")
	public @ResponseBody JsonResultInfo login(LoginCommand loginCommand) {
		String userName = loginCommand.getUserName();
		String password = loginCommand.getPassword();
		boolean isPass = userService.cheakPassword(userName, password);
		if(isPass){
			return new JsonResultInfo(0,"","成功");
		}
		return new JsonResultInfo(1,"用户名或密码不正确","");
	}
}
