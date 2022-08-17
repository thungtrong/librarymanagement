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
import com.tdtu.ktcn.librarymanagement.model.BookIssue;
import com.tdtu.ktcn.librarymanagement.service.BookIssueService;
import com.tdtu.ktcn.librarymanagement.service.BookService;

@CrossOrigin(origins = {ConfigController.ORIGIN})
@RestController
@RequestMapping("book-issue")
public class BookIssueController {
	private BookIssueService bookIssueService;
	private BookService bookService;

	@Autowired
	public BookIssueController(BookIssueService bookIssueservice, BookService bookService) {
		this.bookIssueService = bookIssueservice;
		this.bookService = bookService;
	}

	// CRUD
	@PostMapping("/add")
	public ResponseEntity<BookIssue> addBookIssue(@RequestBody BookIssue bookIssue) {
		bookIssue = bookIssueService.addBookIssue(bookIssue);
		return new ResponseEntity<>(bookIssue, HttpStatus.CREATED);
	}

	@GetMapping("/list")
	public ResponseEntity<Page<BookIssue>> getPageBookIssue(
			@RequestParam Optional<Integer> page,
			@RequestParam Optional<String> sortBy) {
		Page<BookIssue> list = bookIssueService.findPageBookIssue(page.orElse(0), sortBy.orElse("id"));
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<BookIssue> findBookIssueById(@PathVariable Long id) {
		BookIssue bookIssue;
		try {
			bookIssue = bookIssueService.findBookIssueById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(bookIssue, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<BookIssue> updateBookIssue(@RequestBody BookIssue bookIssue) {
		try {
			Boolean check = bookIssueService.findBookIssueById(bookIssue.getId()).getStatus();
			bookIssue = bookIssueService.updateBookIssue(bookIssue);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bookIssue = null;
		} 
		
		return new ResponseEntity<BookIssue>(bookIssue, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteBookIssueById(@RequestBody BookIssue bookIssue) {
		bookIssueService.deleteBookIssueById(bookIssue.getId());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	
	
}
