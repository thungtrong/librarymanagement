package com.tdtu.ktcn.librarymanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tdtu.ktcn.librarymanagement.model.BookIssue;

public interface BookIssueRepository extends JpaRepository<BookIssue, Long>{

}
