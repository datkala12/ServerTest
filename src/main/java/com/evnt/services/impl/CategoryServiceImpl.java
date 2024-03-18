package com.evnt.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evnt.entity.Category;
import com.evnt.repo.CategoryRepo;
import com.evnt.services.CategoryService;



@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired private CategoryRepo cateRepo;

	@Override
	public List<Category> findAll() {
		return cateRepo.findAll();
	}
}
