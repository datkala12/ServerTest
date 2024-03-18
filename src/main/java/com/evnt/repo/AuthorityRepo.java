package com.evnt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.evnt.entity.Account;
import com.evnt.entity.Authority;

@Repository
public interface AuthorityRepo extends JpaRepository<Authority, Integer>{
	@Query("SELECT DISTINCT a FROM authority a WHERE a.accounts IN ?1")
	List<Authority> authoritiesOf(List<Account> accounts);
	
	@Query("Select a From Authority a where a.account.username like ?1")
	List<Authority> getOneByRole(String username);
	
	@Transactional
	@Modifying
	@Query("Delete from Authority where Username = ?1")
	void deleteByUserName(String username);
}
