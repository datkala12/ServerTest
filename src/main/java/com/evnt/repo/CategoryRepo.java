package com.evnt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evnt.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
