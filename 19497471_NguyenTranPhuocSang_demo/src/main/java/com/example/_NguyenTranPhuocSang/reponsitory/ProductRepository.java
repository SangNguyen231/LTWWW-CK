package com.example._NguyenTranPhuocSang.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example._NguyenTranPhuocSang.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query(
            value = "select * from [dbo].[product] where category_id = ?",
            nativeQuery = true)
	public List<Product> getProductByCategory(long category_id);
}
