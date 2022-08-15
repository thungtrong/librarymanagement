package com.tdtu.ktcn.librarymanagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tdtu.ktcn.librarymanagement.model.BookIssue;
import com.tdtu.ktcn.librarymanagement.repo.BookIssueRepository;

@Service
@Transactional
public class BookIssueService {
	private final BookIssueRepository bookIssueRepo;
	private final static int PAGE_SIZE = 10;
	
	@Autowired
	public BookIssueService(BookIssueRepository bookIssueRepo) {
		super();
		this.bookIssueRepo = bookIssueRepo;
	}
	
	// CRUD
	public BookIssue addBookIssue(BookIssue book)
	{
		return bookIssueRepo.save(book);
	}
	
	public List<BookIssue> findAllBookIssue()
	{
		return bookIssueRepo.findAll();
	}
	
	public Page<BookIssue> findPageBookIssue(int page, String sortBy)
	{
		return bookIssueRepo.findAll(
				PageRequest.of(page, PAGE_SIZE, 
						Sort.Direction.DESC, sortBy)
				);
	}
	
	
	public BookIssue findBookIssueById(Long id) throws Exception
	{
		return bookIssueRepo.findById(id).orElseThrow(() -> new Exception(String.format("Not found book issue have a id = %s", id)));
	}
	
	public BookIssue updateBookIssue(BookIssue bookIssue)
	{
		return bookIssueRepo.save(bookIssue);
	}
	
	public void deleteBookIssueById(Long id)
	{
		bookIssueRepo.deleteById(id);
	}
}
