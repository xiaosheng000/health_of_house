package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.AdminMapper;
import com.example.demo.domain.Admin;
import com.example.demo.service.AdminService;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminMapper adminDao;
	
	@Override
	public Admin findUser(String username, String password) {
		Admin admin = adminDao.findUser(username, password);
		return admin;
	}

}
