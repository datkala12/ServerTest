package com.evnt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.evnt.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long>{

	@Query("Select o from Order o Where o.account.username= ?1")
	List<Order> findByUsername(String username);

}
