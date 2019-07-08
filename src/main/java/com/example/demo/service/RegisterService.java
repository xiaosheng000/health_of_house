package com.example.demo.service;

import com.example.demo.domain.Admin;

public interface RegisterService {
	
	void registerUser(Admin admin);
	
	Admin findAllByCode(String username);
}
