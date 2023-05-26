package com.example._NguyenTranPhuocSang.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example._NguyenTranPhuocSang.models.Product;
import com.example._NguyenTranPhuocSang.reponsitory.ProductRepository;
import com.example._NguyenTranPhuocSang.service.ProdcutService;

@Service
public class ProductServiceImp implements ProdcutService {
	@Autowired
	ProductRepository productRepository;
	
	
	@Override
	public void save(Product product) {
		productRepository.save(product);
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> findById(long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

	@Override
	public void delete(long id) {
		productRepository.deleteById(id);
	}

	@Override
	public List<Product> getAllProductByCategoryId(long id) {
		// TODO Auto-generated method stub
		return productRepository.getProductByCategory(id);
	}
}
