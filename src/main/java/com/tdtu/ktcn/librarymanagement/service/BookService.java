package com.tdtu.ktcn.librarymanagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tdtu.ktcn.librarymanagement.model.Book;
import com.tdtu.ktcn.librarymanagement.repo.BookRepository;

@Service
@Transactional
public class BookService {
	private final BookRepository bookRepo;
	private final static int PAGE_SIZE = 10;
	
	@Autowired
	public BookService(BookRepository bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}
	
	// CRUD
	public Book addBook(Book book)
	{
		return bookRepo.save(book);
	}
	
	public List<Book> findAllBook()
	{
		return bookRepo.findAll();
	}
	
	public List<Book> findBooksByTitleContains(String searchString)
	{
		return bookRepo.findAllByTitleContainsIgnoreCase(searchString);
	}
	
	public Page<Book> findPageBook(int page, String sortBy)
	{
		return bookRepo.findAll(
				PageRequest.of(page, PAGE_SIZE, 
						Sort.Direction.ASC, sortBy)
				);
	}
	
	public Book findBookById(Integer id) throws Exception
	{
		return bookRepo.findById(id).orElseThrow(() -> new Exception(String.format("Not found book have a id = %s", id)));
	}
	
	
	public Book updateBook(Book book)
	{
		return bookRepo.save(book);
	}
	
	
	public void deleteBookById(Integer id)
	{
		bookRepo.deleteById(id);
	}
}
