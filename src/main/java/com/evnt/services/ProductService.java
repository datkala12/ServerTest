package com.evnt.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.evnt.entity.Product;

public interface ProductService{

	Page<Product> findAll(Pageable pageable);
	
	Page<Product> findByCategoryID(String cid,Pageable pageable);
	
	List<Product> findAll();

	Product findById(Integer productID);

	List<Product> findByCategoryID(String cid);

	Product create(Product product);

	Product update(Product product);

	void delete(Integer id);

}
