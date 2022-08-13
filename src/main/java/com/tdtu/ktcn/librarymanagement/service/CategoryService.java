package com.tdtu.ktcn.librarymanagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tdtu.ktcn.librarymanagement.model.Category;
import com.tdtu.ktcn.librarymanagement.repo.CategoryRepository;

@Service
@Transactional
public class CategoryService {
	private final CategoryRepository categoryRepo;
	private final static int PAGE_SIZE = 10;
	
	@Autowired
	public CategoryService(CategoryRepository categoryRepo) {
		super();
		this.categoryRepo = categoryRepo;
	}
	
	// CRUD
	public Category addCategory(Category category)
	{
		return categoryRepo.save(category);
	}
	
	public List<Category> findAllCategory()
	{
		return categoryRepo.findAll();
	}
	
	public Page<Category> findPageCategory(int page, String sortBy)
	{
		return categoryRepo.findAll(
				PageRequest.of(page, PAGE_SIZE, 
						Sort.Direction.DESC, sortBy)
				);
	}
	
	public Category findCategoryById(Integer id) throws Exception
	{
		return categoryRepo.findById(id).orElseThrow(() -> new Exception(String.format("Not found category have a id = %s", id)));
	}
	
	public Category updateCategory(Category category)
	{
		return categoryRepo.save(category);
	}
	
	public void deleteCategoryById(Integer id)
	{
		categoryRepo.deleteById(id);
	}
}
