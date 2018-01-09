package com.neusoft.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neusoft.entity.Account;
import com.neusoft.service.AccountService;

@Controller
public class LoginController {

	@Autowired
	 private AccountService accService;
	
	 @RequestMapping(value="login")
	 public String login() {
		 
		 return "login";
	 }
	 
	 @RequestMapping(value="login",method=RequestMethod.POST)
	 public String login(HttpServletRequest request,Model model) {
		 
		 String _email=request.getParameter("email");
		 String _psw=request.getParameter("password");
		 
		 Account acc=new Account(_email,_psw);
		 Account _acc= accService.findAccount(acc);
		 System.out.println("acc="+_acc);
		model.addAttribute("test", "el succ");
		 if(_acc!=null) {
			 return "redirect:/home";
		 }
		
		 return "login";
	 }
	
}
