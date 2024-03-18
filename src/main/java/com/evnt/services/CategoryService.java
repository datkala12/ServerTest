package com.evnt.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.evnt.entity.Category;

@Service
public interface CategoryService {

	List<Category> findAll();

}
