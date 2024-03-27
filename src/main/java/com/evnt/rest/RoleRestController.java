package com.evnt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evnt.entity.Role;
import com.evnt.services.RoleService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/role")
public class RoleRestController {

	@Autowired
	RoleService roleService;

	@GetMapping
	public List<Role> getAll() {
		return roleService.findAll();
	}

}