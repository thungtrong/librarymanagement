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

import com.tdtu.ktcn.librarymanagement.model.Book;
import com.tdtu.ktcn.librarymanagement.service.BookService;

@CrossOrigin(origins = { ConfigController.ORIGIN })
@RestController
@RequestMapping("book")
public class BookController {
	private BookService bookService;

	@Autowired
	public BookController(BookService bookservice) {
		this.bookService = bookservice;
	}

	// CRUD
	@PostMapping("/add")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		book = bookService.addBook(book);
		return new ResponseEntity<>(book, HttpStatus.CREATED);
	}

	@GetMapping("/list")
	public ResponseEntity<Page<Book>> getPageBook(@RequestParam Optional<Integer> page,
			@RequestParam Optional<String> sortBy) {
		Page<Book> list = bookService.findPageBook(page.orElse(0), sortBy.orElse("title"));
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Book> findBookById(@PathVariable Integer id) {
		Book book;
		try {
			book = bookService.findBookById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {
		book = bookService.updateBook(book);
		return new ResponseEntity<Book>(book, HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/delete")
	public ResponseEntity<Boolean> deleteBookById(@RequestBody Book book) {
		if (book.getStatus()) {
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_ACCEPTABLE);
		}
		bookService.deleteBookById(book.getId());
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	// Custom

	@GetMapping("/find-by-status")
	public ResponseEntity<Page<Book>> getPageBookByStatus(@RequestParam Optional<Boolean> status,
			@RequestParam Optional<Integer> page, @RequestParam Optional<String> sortBy) {
		Page<Book> list = bookService.findPageBookByStatus(status.orElse(true), page.orElse(0), sortBy.orElse("title"));
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/find-by-title")
	public ResponseEntity<List<Book>> findBookByTitle(@RequestParam Optional<String> search) {
		List<Book> list = this.bookService.findBooksByTitleContains(search.orElse(" "));
		return new ResponseEntity<List<Book>>(list, HttpStatus.OK);
	}

	@PutMapping("/update-multiple")
	public ResponseEntity<Boolean> updateMultipleBook(@RequestBody Book[] books) {
		try
		{			
			for (Book book: books)
			{
				bookService.updateBook(book);
			}
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
	}
	
}
