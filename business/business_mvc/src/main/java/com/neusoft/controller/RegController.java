package com.neusoft.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neusoft.entity.Account;
import com.neusoft.service.AccountService;



@Controller
public class RegController {
    @Autowired
	private AccountService accService;
	
	@RequestMapping("/reg")
	public String reg() {
		return "reg";
	}
	
	
	@RequestMapping(value="/reg",method=RequestMethod.POST)
	public String reg(HttpServletRequest request) {
		//用户
		String _email=request.getParameter("email");
		String _pwd=request.getParameter("password");
		Account acc=new Account(_email,_pwd);
		accService.doReg(acc);
		return "succ";
	}
	
	
	
}
