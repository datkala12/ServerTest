package com.evnt.rest;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evnt.entity.Account;
import com.evnt.services.AccountService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/account")
public class AccountRestController {
	
	@Autowired
	AccountService accountService;

	@GetMapping
	public List<Account> getAccounts(@RequestParam("admin") Optional<Boolean> admin) {
		if (admin.orElse(false)) {
			return accountService.getAdministrators();
		}
		return accountService.findAll();
	}

//	@RequestMapping(value= "/account", method = RequestMethod.GET,
//			produces = "application/json")
//	public List<Account> getAccount() {
//		return accountService.findAll();
//	}

	@GetMapping("{id}")
	public Account getOne(@PathVariable("username") String username) {
		return accountService.findById(username);
	}

	@PostMapping
	public Account create(@RequestBody Account account) {
		return accountService.create(account);
	}

	@PutMapping("{id}")
	public Account update(@PathVariable("username") String username, @RequestBody Account account) {
		return accountService.update(account);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable("username") String username) {
		Account account = accountService.findById(username);
		if (account != null) {
		    accountService.delete(account);
		} else {
			System.out.println("Error can not find any account name like that!");
		}
	}
}
