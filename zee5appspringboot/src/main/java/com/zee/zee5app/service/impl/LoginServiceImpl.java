package com.zee.zee5app.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginRepository repository;

	@Override
	public String addCredentials(Login login) {
		// TODO Auto-generated method stub
		Login result = repository.save(login);
		if (result != null)
			return "success";
		return "fail";
	}

	@Override
	public String deleteCredentials(String userName) {
		Optional<Login> register3 = repository.findById(userName);
		if (register3.isEmpty())
			return "fail";
		else {
			repository.deleteById(userName);
			return "success";
		}
	}

}
