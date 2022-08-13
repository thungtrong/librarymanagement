package com.tdtu.ktcn.librarymanagement.controller;

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

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("book")
public class BookController {
	private BookService bookService;
	
	@Autowired
	public BookController(BookService bookservice)
	{
		this.bookService = bookservice;
	}
	
	// CRUD
		@PostMapping("/add")
		public ResponseEntity<Book> addBook(@RequestBody Book book) {
			book = bookService.addBook(book);
			return new ResponseEntity<>(book, HttpStatus.CREATED);
		}
		
		@GetMapping("/list")
		public ResponseEntity<Page<Book>> getPageBook(
				@RequestParam Optional<Integer> page,
				@RequestParam Optional<String> sortBy
				) {
			Page<Book> list = bookService.findPageBook(
					page.orElse(0), sortBy.orElse("id"));
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
		public ResponseEntity<Book>  updateBook(@RequestBody Book book) {
			book = bookService.updateBook(book);
			return new ResponseEntity<Book>(book, HttpStatus.ACCEPTED);
		}

		@DeleteMapping("/delete")
		public ResponseEntity<?> deleteBookById(@RequestBody Book book) {
			bookService.deleteBookById(book.getId());
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
}
