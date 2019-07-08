package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.domain.Admin;



@Mapper
public interface AdminMapper {
	/*
	 * 	通过账号和密码查询用户
	 */
	 public Admin findUser(@Param("username") String username,
			        	   @Param("password") String password);
}
