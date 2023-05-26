package com.example._NguyenTranPhuocSang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example._NguyenTranPhuocSang.models.Category;
import com.example._NguyenTranPhuocSang.models.Product;
import com.example._NguyenTranPhuocSang.service.CategoryService;
import com.example._NguyenTranPhuocSang.service.ProdcutService;


@org.springframework.stereotype.Controller
@RequestMapping("/products")
public class Controller {

	@Autowired
	ProdcutService prodcutService;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("")
	public ModelAndView findAllProducts() {
		ModelAndView model = new ModelAndView();
		model.addObject("category", new Category());
		model.addObject("products", prodcutService.findAll());
		model.addObject("categorys", categoryService.findAll());
		model.setViewName("product_listing");
		return model;
	}
	
	@GetMapping("/category")
	public ModelAndView findAllProductsByCategory(@RequestParam long categoryId) {
		ModelAndView model = new ModelAndView();
		
		model.addObject("products", prodcutService.getAllProductByCategoryId(categoryId));
		
		model.setViewName("product_listing");
		return model;
	}
	
	@GetMapping("/showAddForm")
	public ModelAndView showAddForm(){
		ModelAndView model = new ModelAndView();
		model.addObject("product", new Product());
		model.addObject("categorys", categoryService.findAll());
		model.setViewName("add_product_form");
		return model;
	}
	
	@PostMapping("/saveProduct")
    public ModelAndView saveProduct(@ModelAttribute Product product) {
        ModelAndView modelAndView = new ModelAndView();
        prodcutService.save(product);
        modelAndView.setViewName("redirect:/products");
        return modelAndView;
    }
	
	@GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView();
        Product product = prodcutService.findById(id).get();
        modelAndView.addObject("product", product);
        modelAndView.setViewName("add_product_form");
        return modelAndView;
    }
	
	@GetMapping("/delete")
    public ModelAndView deleteProduct(long id) {
        ModelAndView model = new ModelAndView();
        prodcutService.delete(id);
        model.setViewName("redirect:/products");
        return model;
    }
}
