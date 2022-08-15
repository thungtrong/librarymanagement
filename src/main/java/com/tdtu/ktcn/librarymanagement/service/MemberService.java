package com.tdtu.ktcn.librarymanagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tdtu.ktcn.librarymanagement.model.Member;
import com.tdtu.ktcn.librarymanagement.repo.MemberRepository;

@Service
@Transactional
public class MemberService {
	private final MemberRepository memberRepo;
	private final static int PAGE_SIZE = 4;
	
	@Autowired
	public MemberService(MemberRepository memberRepo) {
		super();
		this.memberRepo = memberRepo;
	}
	
	// CRUD
	public Member addMember(Member member)
	{
		return memberRepo.save(member);
	}
	
	public List<Member> findAllMember()
	{
		return memberRepo.findAll();
	}
	
	public Page<Member> findPageMember(int page, String sortBy)
	{
		return memberRepo.findAll(
				PageRequest.of(page, PAGE_SIZE, 
						Sort.Direction.ASC, sortBy)
				);
	}
	
	public Member findMemberById(Integer id) throws Exception
	{
		return memberRepo.findById(id).orElseThrow(() -> new Exception(String.format("Not found member have a id = %s", id)));
	}
	
	public Member updateMember(Member member)
	{
		return memberRepo.save(member);
	}
	
	public void deleteMemberById(Integer id)
	{
		memberRepo.deleteById(id);
	}
	// Custom
	public List<Member> findAllByFirstNameContainsAndLastNameContains(String firstname, String lastname)
	{
		return memberRepo.findAllByFirstNameContainsIgnoreCaseAndLastNameContainsIgnoreCase(firstname, lastname);
	}
}
