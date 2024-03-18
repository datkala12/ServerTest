package com.evnt.rest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evnt.entity.Account;
import com.evnt.services.AccountService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class AccountRestController {

	@Autowired
	AccountService accountService;

	@GetMapping("accounts")
	public List<Account> getAccounts(@RequestParam("admin") Optional<Boolean> admin) {
		if (admin.orElse(false)) {
			return accountService.getAdministrators();
		}
		return accountService.findAll();
	}
	
	 @PostMapping("/login")
	    public ResponseEntity<String> login(@RequestBody Map<String, String> loginRequest) {
	        String username = loginRequest.get("username");
	        String password = loginRequest.get("password");
	        
	        Account account = accountService.findById(username);
	        if (account != null && account.getPassword().equals(password)) {
	            return ResponseEntity.ok("Login successful");
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
	        }
	    }
	 
	@PostMapping("accountsManage")
	public Account create(@RequestBody Account account) {
		return accountService.create(account);
	}
	
	@PutMapping("accounts/{id}")
	public Account update(@RequestBody Account account,@PathVariable("id")String username) {
		return accountService.update(account);
	}
}
