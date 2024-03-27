package com.evnt.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.evnt.entity.Account;

@EnableJpaRepositories
@Repository
public interface AccountRepo extends JpaRepository<Account, String> {
	@Query("SELECT DISTINCT ar.accounts FROM authority ar WHERE ar.roles.role_id IN('Admin','User','Manager')")
	List<Account> getAdministrators();
	
	public Account findByEmail(String email);
}
