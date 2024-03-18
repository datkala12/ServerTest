package com.evnt.services;

import java.util.List;

import com.evnt.entity.Authority;

public interface AuthorityService {

	public List<Authority> findAuthoritiesOfAdministrators();

	public List<Authority> findAll();

	public Authority create(Authority auth);

	public void delete(Integer id);
	
	List<Authority> getOneByRole(String username);

	void deleteByUsername(String username);

	Long getTotalCustomer();
}
