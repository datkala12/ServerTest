package com.evnt.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.evnt.dao.RoleDAO;
import com.evnt.entity.Role;
import com.evnt.repo.RoleRepo;
import com.evnt.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleRepo rrepo;
	
	public List<Role> findAll() {
		return rrepo.findAll();
	}
}
