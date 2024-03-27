package com.evnt.services;

import java.util.List;

import com.evnt.entity.Account;

public interface AccountService {
	Account findById(String username);

	List<Account> getAdministrators();
	
	List<Account> findAll();

	Account create(Account account);

	Account update(Account account);
	
	Account delete(Account account);

	Long getTotalAccount();
}
