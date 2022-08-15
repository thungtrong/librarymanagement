package com.tdtu.ktcn.librarymanagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tdtu.ktcn.librarymanagement.model.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{
	List<Member> findAllByFirstNameContainsIgnoreCaseAndLastNameContainsIgnoreCase(String firstname, String lastname);
}
