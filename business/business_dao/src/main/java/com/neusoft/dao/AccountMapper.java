package com.neusoft.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.neusoft.entity.Account;

/**
 * 账户的CRUD
 * */
@Mapper
@Repository
public interface AccountMapper {

	/**
	 * 添加用户信息
	 * */
	public void addAccount(Account acc);
	
	/**
	 * 登录
	 * */
	public Account findAccount(Account acc);
	
}
