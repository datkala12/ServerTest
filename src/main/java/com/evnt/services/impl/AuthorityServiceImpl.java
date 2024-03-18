package com.evnt.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evnt.entity.Account;
import com.evnt.entity.Authority;
import com.evnt.repo.AccountRepo;
import com.evnt.repo.AuthorityRepo;
import com.evnt.services.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService {
	@Autowired
	AuthorityRepo arepo;
	
	@Autowired
	AccountRepo acrepo;

	@Override
	public List<Authority> findAuthoritiesOfAdministrators() {
		List<Account> accounts = acrepo.getAdministrators();
		return arepo.authoritiesOf(accounts);
	}

	@Override
	public List<Authority> findAll() {
		return arepo.findAll();
	}

	@Override
	public Authority create(Authority auth) {
		return arepo.save(auth);
	}

	@Override
	public void delete(Integer id) {
		arepo.deleteById(id);
	}
	
	@Override
	public List<Authority> getOneByRole(String username) {
		return arepo.getOneByRole(username);
	}

	@Override
	public void deleteByUsername(String username) {
		arepo.deleteByUserName(username);
	}

	/*Summary*/
	@Override
	public Long getTotalCustomer() {
		return arepo.findAll().stream().filter(e->e.getRole().getName().equals("Customers")).count();
	}
}
