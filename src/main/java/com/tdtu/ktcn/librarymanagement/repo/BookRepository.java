package com.tdtu.ktcn.librarymanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tdtu.ktcn.librarymanagement.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
