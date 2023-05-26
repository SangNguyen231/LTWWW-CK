package com.example._NguyenTranPhuocSang.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example._NguyenTranPhuocSang.models.Category;

@Service
public interface CategoryService {
	void save(Category product);
	
	List<Category> findAll();
	
	Optional<Category> findById(long id);
	
	void delete(long id);
}
