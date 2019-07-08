package com.example.demo.service;

import org.apache.ibatis.annotations.Param;

import com.example.demo.domain.Admin;

public interface AdminService {
	/*
	 * 	通过账号和密码查询用户
	 */
	 public Admin findUser(@Param("username") String username,
			        	   @Param("password") String password);
}
