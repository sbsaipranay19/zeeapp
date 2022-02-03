package com.zee.zee5app.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Role;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleRepository roleRepository;
	@Override
	@Transactional(rollbackOn = Exception.class)
	public String addRole(Role role) {
		// TODO Auto-generated method stub
		Role erole = roleRepository.save(role);
		if(erole!=null) return "success";
		return "fail";
	}

	@Override
	public String deleteRole(int roleId) {
		// TODO Auto-generated method stub
		return null;
	}

}
