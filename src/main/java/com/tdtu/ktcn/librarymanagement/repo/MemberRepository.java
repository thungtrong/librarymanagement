package com.tdtu.ktcn.librarymanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tdtu.ktcn.librarymanagement.model.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{

}
