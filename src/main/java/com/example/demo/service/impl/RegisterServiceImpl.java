package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.RegisterMapper;
import com.example.demo.domain.Admin;
import com.example.demo.service.RegisterService;

@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterMapper registerMapper;

	@Override
	public void registerUser(Admin admin) {
		
		registerMapper.registerUser(admin);
		
	}

	@Override
	public Admin findAllByCode(String username) {

		Admin admin = registerMapper.findAllByCode(username);
		
		return admin;
	}
	
	

}
