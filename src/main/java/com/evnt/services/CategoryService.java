package com.evnt.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.evnt.entity.Category;

@Service
public interface CategoryService {

	List<Category> findAll();

	Category findById(Integer id);

	Category create(Category category);

	Category update(Category category);

	void delete(Integer id);
}
