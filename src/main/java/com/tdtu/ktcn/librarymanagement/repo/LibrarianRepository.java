package com.tdtu.ktcn.librarymanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tdtu.ktcn.librarymanagement.model.Librarian;

public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {

}
