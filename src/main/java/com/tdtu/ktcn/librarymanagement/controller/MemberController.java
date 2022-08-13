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

import com.tdtu.ktcn.librarymanagement.model.Member;
import com.tdtu.ktcn.librarymanagement.service.MemberService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("member")
public class MemberController {
	private MemberService memberService;

	@Autowired
	public MemberController(MemberService memberservice) {
		this.memberService = memberservice;
	}

	// CRUD
	@PostMapping("/add")
	public ResponseEntity<Member> addMember(@RequestBody Member member) {
		member = memberService.addMember(member);
		return new ResponseEntity<>(member, HttpStatus.CREATED);
	}

	@GetMapping("/list")
	public ResponseEntity<Page<Member>> getPageMember(@RequestParam Optional<Integer> page,
			@RequestParam Optional<String> sortBy) {
		Page<Member> list = memberService.findPageMember(page.orElse(0), sortBy.orElse("id"));
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Member> findMemberById(@PathVariable Integer id) {
		Member member;
		try {
			member = memberService.findMemberById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(member, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Member> updateMember(@RequestBody Member member) {
		member = memberService.updateMember(member);
		return new ResponseEntity<Member>(member, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteMemberById(@RequestBody Member member) {
		memberService.deleteMemberById(member.getId());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
