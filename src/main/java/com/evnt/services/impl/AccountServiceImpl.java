package com.evnt.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evnt.entity.Account;
import com.evnt.repo.AccountRepo;
import com.evnt.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepo accrepo;

	@Override
	public Account findById(String username) {
		return accrepo.findByEmail(username);
	}

	@Override
	public List<Account> findAll() {
		return accrepo.findAll();
	}

	@Override
	public List<Account> getAdministrators() {
		return accrepo.getAdministrators();
	}

	@Override
	public Account create(Account account) {
		return accrepo.save(account);
	}

	@Override
	public Account update(Account account) {
		return accrepo.save(account);
	}
	
	@Override
	public Account delete(Account account) {
		return accrepo.save(account);
	}
	
	@Override
	public Long getTotalAccount() {
		return accrepo.count();
	}
}
