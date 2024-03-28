package com.evnt.rest;
import com.evnt.entity.Account;
import com.evnt.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public Account login(@RequestParam String username, @RequestParam String password) {
        return accountService.login(username, password);
    }

    @PostMapping("/register")
    public Account register(@RequestBody Account account) {
        return accountService.register(account);
    }

    @GetMapping("/logout")
    public void logout(@RequestParam String username) {
        accountService.logout(username);
    }
}
