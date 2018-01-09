package com.neusoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.dao.AccountMapper;
import com.neusoft.entity.Account;
@Service
public class AccountService {
     @Autowired
	 private AccountMapper accDao;
	 
	 public void doReg(Account acc) {
		 accDao.addAccount(acc);
	 }
	
	 /**
	  * 登录
	  * */
	 public Account findAccount(Account acc) {
		 return accDao.findAccount(acc);
	 }
}
