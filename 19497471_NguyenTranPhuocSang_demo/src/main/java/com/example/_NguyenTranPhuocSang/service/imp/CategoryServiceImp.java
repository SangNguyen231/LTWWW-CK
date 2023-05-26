package com.example._NguyenTranPhuocSang.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example._NguyenTranPhuocSang.models.Category;
import com.example._NguyenTranPhuocSang.reponsitory.CategoryRepository;
import com.example._NguyenTranPhuocSang.service.CategoryService;

@Service
public class CategoryServiceImp implements CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	
	@Override
	public void save(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Optional<Category> findById(long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id);
	}

	@Override
	public void delete(long id) {
		categoryRepository.deleteById(id);
	}

}
