package com.tdtu.ktcn.librarymanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tdtu.ktcn.librarymanagement.model.Category;
import com.tdtu.ktcn.librarymanagement.service.CategoryService;
@CrossOrigin(origins = {ConfigController.ORIGIN})
@RestController
@RequestMapping("category")
public class CategoryController {
	private CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryservice) {
		this.categoryService = categoryservice;
	}

	// CRUD
	@PostMapping("/add")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {
		category = categoryService.addCategory(category);
		return new ResponseEntity<>(category, HttpStatus.CREATED);
	}

	@GetMapping("/list")
	public ResponseEntity<Page<Category>> getPageCategory(@RequestParam Optional<Integer> page,
			@RequestParam Optional<String> sortBy) {
		Page<Category> list = categoryService.findPageCategory(page.orElse(0), sortBy.orElse("name"));
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Category>> getAllCategory() {
		List<Category> categories = categoryService.findAllCategory();
		return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Category> findCategoryById(@PathVariable Integer id) {
		Category category;
		try {
			category = categoryService.findCategoryById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(category, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
		category = categoryService.updateCategory(category);
		return new ResponseEntity<Category>(category, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteCategoryById(@RequestBody Category category) {
		categoryService.deleteCategoryById(category.getId());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
