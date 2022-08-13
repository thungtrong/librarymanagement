package com.tdtu.ktcn.librarymanagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tdtu.ktcn.librarymanagement.model.MemberType;
import com.tdtu.ktcn.librarymanagement.repo.MemberTypeRepository;

@Service
@Transactional
public class MemberTypeService {
	private final MemberTypeRepository memberTypeRepo;
	private final static int PAGE_SIZE = 10;
	
	@Autowired
	public MemberTypeService(MemberTypeRepository memberTypeRepo) {
		super();
		this.memberTypeRepo = memberTypeRepo;
	}
	
	// CRUD
	public MemberType addMemberType(MemberType memberType)
	{
		return memberTypeRepo.save(memberType);
	}
	
	public List<MemberType> findAllMemberType()
	{
		return memberTypeRepo.findAll();
	}
	
	public Page<MemberType> findPageMemberType(int page, String sortBy)
	{
		return memberTypeRepo.findAll(
				PageRequest.of(page, PAGE_SIZE, 
						Sort.Direction.DESC, sortBy)
				);
	}
	
	public MemberType findMemberTypeById(Integer id) throws Exception
	{
		return memberTypeRepo.findById(id).orElseThrow(() -> new Exception(String.format("Not found memberType issue have a id = %s", id)));
	}
	
	public MemberType updateMemberType(MemberType announcement)
	{
		return memberTypeRepo.save(announcement);
	}
	
	public void deleteMemberTypeById(Integer id)
	{
		memberTypeRepo.deleteById(id);
	}
}
