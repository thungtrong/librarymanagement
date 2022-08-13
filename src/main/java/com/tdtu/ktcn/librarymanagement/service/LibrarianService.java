package com.tdtu.ktcn.librarymanagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tdtu.ktcn.librarymanagement.model.Librarian;
import com.tdtu.ktcn.librarymanagement.repo.LibrarianRepository;

@Service
@Transactional
public class LibrarianService {
	private final LibrarianRepository librarianRepo;
	private final static int PAGE_SIZE = 10;
	
	@Autowired
	public LibrarianService(LibrarianRepository librarianRepo) {
		super();
		this.librarianRepo = librarianRepo;
	}
	
	// CRUD
	public Librarian addLibrarian(Librarian librarian)
	{
		return librarianRepo.save(librarian);
	}
	
	public List<Librarian> findAllLibrarian()
	{
		return librarianRepo.findAll();
	}
	
	public Page<Librarian> findPageLibrarian(int page, String sortBy)
	{
		return librarianRepo.findAll(
				PageRequest.of(page, PAGE_SIZE, 
						Sort.Direction.DESC, sortBy)
				);
	}
	
	public Librarian findLibrarianById(Integer id) throws Exception
	{
		return librarianRepo.findById(id).orElseThrow(() -> new Exception(String.format("Not found librarian have a id = %s", id)));
	}
	
	public Librarian updateLibrarian(Librarian librarian)
	{
		return librarianRepo.save(librarian);
	}
	
	public void deleteLibrarianById(Integer id)
	{
		librarianRepo.deleteById(id);
	}
}
