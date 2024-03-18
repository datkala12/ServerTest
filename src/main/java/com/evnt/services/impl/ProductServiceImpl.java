package com.evnt.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.evnt.entity.Product;
import com.evnt.repo.ProductRepo;
import com.evnt.services.ProductService;



@Service
public class ProductServiceImpl implements ProductService{
	@Autowired private ProductRepo prepo;

	@Override
	public List<Product> findAll() {
		return prepo.findAll();
	}

	@Override
	public Product findById(Integer productID) {
		return prepo.findById(productID).get();
	}

	@Override
	public List<Product> findByCategoryID(String cid) {
		return prepo.findByCategoryId(cid);
	}

	@Override
	public Product create(Product product) {
		return prepo.save(product);
	}

	@Override
	public Product update(Product product) {
		return prepo.save(product);
	}

	@Override
	public void delete(Integer id) {
		prepo.deleteById(id);
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return prepo.findAll(pageable);
	}

	@Override
	public Page<Product> findByCategoryID(String cid,Pageable pageable) {
		return prepo.findByCategoryId(cid,pageable);
	}
}
