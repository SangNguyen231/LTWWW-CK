package com.example._NguyenTranPhuocSang.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example._NguyenTranPhuocSang.models.Product;

@Service
public interface ProdcutService {
	
	List<Product> getAllProductByCategoryId(long id);
	
	void save(Product product);
	
	List<Product> findAll();
	
	Optional<Product> findById(long id);
	
	void delete(long id);
}
