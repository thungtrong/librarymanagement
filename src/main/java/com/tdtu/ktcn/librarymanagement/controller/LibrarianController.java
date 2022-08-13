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

import com.tdtu.ktcn.librarymanagement.model.Librarian;
import com.tdtu.ktcn.librarymanagement.service.LibrarianService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("librarian")
public class LibrarianController {
	private LibrarianService librarianService;

	@Autowired
	public LibrarianController(LibrarianService librarianservice) {
		this.librarianService = librarianservice;
	}

	// CRUD
	@PostMapping("/add")
	public ResponseEntity<Librarian> addLibrarian(@RequestBody Librarian librarian) {
		librarian = librarianService.addLibrarian(librarian);
		return new ResponseEntity<>(librarian, HttpStatus.CREATED);
	}

	@GetMapping("/list")
	public ResponseEntity<Page<Librarian>> getPageLibrarian(@RequestParam Optional<Integer> page,
			@RequestParam Optional<String> sortBy) {
		Page<Librarian> list = librarianService.findPageLibrarian(page.orElse(0), sortBy.orElse("id"));
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Librarian> findLibrarianById(@PathVariable Integer id) {
		Librarian librarian;
		try {
			librarian = librarianService.findLibrarianById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(librarian, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Librarian> updateLibrarian(@RequestBody Librarian librarian) {
		librarian = librarianService.updateLibrarian(librarian);
		return new ResponseEntity<Librarian>(librarian, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteLibrarianById(@RequestBody Librarian librarian) {
		librarianService.deleteLibrarianById(librarian.getId());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
