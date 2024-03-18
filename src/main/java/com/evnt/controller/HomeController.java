package com.evnt.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evnt.entity.Account;
import com.evnt.repo.AccountRepo;
import com.evnt.services.AccountService;

@Controller
public class HomeController {
	
	@GetMapping({"","/home"})
	public String home(Model model, Principal principal) {
		return "home";
	}
	
//	@GetMapping({"admin","admin/home"})
//	public String admin() {
//		return "redirect:/assets/admin/index.html";
//	}
}
