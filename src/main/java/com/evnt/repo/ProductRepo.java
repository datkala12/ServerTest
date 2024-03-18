package com.evnt.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.evnt.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

	@Query("Select p From Product p Where p.category.id=?1")
	List<Product> findByCategoryId(String cid);
	
	@Query("Select p From Product p Where p.category.id=?1")
	Page<Product> findByCategoryId(String cid,Pageable pageable);
}
