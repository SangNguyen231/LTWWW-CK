package com.example._NguyenTranPhuocSang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example._NguyenTranPhuocSang.models.Category;
import com.example._NguyenTranPhuocSang.models.Product;
import com.example._NguyenTranPhuocSang.service.CategoryService;

@Controller
@RequestMapping("/categorys")
public class CategoryCotroller {
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("")
	public ModelAndView findAllCategorys() {
		ModelAndView model = new ModelAndView();
		model.addObject("categorys", categoryService.findAll());
		model.setViewName("category_listing");
		return model;
	}
	
	@GetMapping("/showAddForm")
	public ModelAndView showAddForm(){
		ModelAndView model = new ModelAndView();
		model.addObject("category", new Category());
		model.setViewName("add_category_form");
		return model;
	}
	
	@PostMapping("/saveCategory")
    public ModelAndView save(@ModelAttribute Category category) {
        ModelAndView modelAndView = new ModelAndView();
        categoryService.save(category);
        modelAndView.setViewName("redirect:/categorys");
        return modelAndView;
    }
	
	@GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView();
        Category category = categoryService.findById(id).get();
        modelAndView.addObject("category", category);
        modelAndView.setViewName("add_category_form");
        return modelAndView;
    }
	
	@GetMapping("/delete")
    public ModelAndView delete(long id) {
        ModelAndView model = new ModelAndView();
        categoryService.delete(id);
        model.setViewName("redirect:/categorys");
        return model;
    }
}
