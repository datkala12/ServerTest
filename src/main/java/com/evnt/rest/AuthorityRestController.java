package com.evnt.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evnt.entity.Authority;
import com.evnt.services.AuthorityService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/authority")
public class AuthorityRestController {

	@Autowired
	AuthorityService authorityService;

	@GetMapping("authorities")
	public List<Authority> findAll(@RequestParam("admin") Optional<Boolean> admin) {
		if (admin.orElse(false)) {
			return authorityService.findAuthoritiesOfAdministrators();
		}
		return authorityService.findAll();
	}

	@GetMapping("authoritiesOne")
	public List<Authority> getOneByRole(@RequestParam("username")String username){
		return authorityService.getOneByRole(username);
	}
	
	
	@PostMapping("authorities")
	public Authority post(@RequestBody Authority auth) {
		return authorityService.create(auth);
	}
	
	@DeleteMapping("authorities/{id}")
	public void delete(@PathVariable("id") Integer id) {
		authorityService.delete(id);
	}
	
	@DeleteMapping("authoritiesOne/{username}")
	public void deleteByUsername(@PathVariable("username") String username) {
		System.out.println("username del: "+username);
		authorityService.deleteByUsername(username);
	}
}
