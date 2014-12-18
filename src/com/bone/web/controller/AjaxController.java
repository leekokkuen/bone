package com.bone.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/ajax")
public class AjaxController{
	
	@RequestMapping(value="/ajax.html")
	public String ajax(){
		return "/testAjex";
	}
	
	@RequestMapping(value="/ajaxCommit.html")
	@ResponseBody
	public String ajaxCommit() throws InterruptedException{
		return "hello Ajax";
	}
}
