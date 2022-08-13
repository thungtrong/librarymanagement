package com.tdtu.ktcn.librarymanagement.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tdtu.ktcn.librarymanagement.model.MemberType;
import com.tdtu.ktcn.librarymanagement.service.MemberTypeService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("membertype")
public class MemberTypeController {
	private MemberTypeService memberTypeService;

	@Autowired
	public MemberTypeController(MemberTypeService memberTypeservice) {
		this.memberTypeService = memberTypeservice;
	}

	// CRUD
	@PostMapping("/add")
	public ResponseEntity<MemberType> addMemberType(@RequestBody MemberType memberType) {
		memberType = memberTypeService.addMemberType(memberType);
		return new ResponseEntity<>(memberType, HttpStatus.CREATED);
	}

	@GetMapping("/list")
	public ResponseEntity<Page<MemberType>> getPageMemberType(@RequestParam Optional<Integer> page,
			@RequestParam Optional<String> sortBy) {
		Page<MemberType> list = memberTypeService.findPageMemberType(page.orElse(0), sortBy.orElse("id"));
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<MemberType> findMemberTypeById(@PathVariable Integer id) {
		MemberType memberType;
		try {
			memberType = memberTypeService.findMemberTypeById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(memberType, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<MemberType> updateMemberType(@RequestBody MemberType memberType) {
		memberType = memberTypeService.updateMemberType(memberType);
		return new ResponseEntity<MemberType>(memberType, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteMemberTypeById(@RequestBody MemberType memberType) {
		memberTypeService.deleteMemberTypeById(memberType.getId());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
