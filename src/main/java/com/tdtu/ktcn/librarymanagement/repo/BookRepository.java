package com.tdtu.ktcn.librarymanagement.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tdtu.ktcn.librarymanagement.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	
	List<Book> findAllByTitleContainsIgnoreCase(String keyword);
}
