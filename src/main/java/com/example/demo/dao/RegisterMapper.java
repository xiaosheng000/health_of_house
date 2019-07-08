package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.Admin;

@Mapper
public interface RegisterMapper {

	void registerUser(Admin admin);
	
	Admin findAllByCode(String username);
}
