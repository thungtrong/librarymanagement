package com.tdtu.ktcn.librarymanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tdtu.ktcn.librarymanagement.model.DashBoardModel;
import com.tdtu.ktcn.librarymanagement.model.DashBoardModel.Info;
import com.tdtu.ktcn.librarymanagement.model.Librarian;
import com.tdtu.ktcn.librarymanagement.repo.BookIssueRepository;
import com.tdtu.ktcn.librarymanagement.repo.BookRepository;
import com.tdtu.ktcn.librarymanagement.repo.CategoryRepository;
import com.tdtu.ktcn.librarymanagement.repo.LibrarianRepository;
import com.tdtu.ktcn.librarymanagement.repo.MemberRepository;
import com.tdtu.ktcn.librarymanagement.repo.MemberTypeRepository;

@Service
public class DashBoardService {
	private MemberRepository member;
	private MemberTypeRepository memberType;
	private CategoryRepository category;
	private BookRepository book;
	private BookIssueRepository bookIssue;
	private LibrarianRepository libarian;

	@Autowired
	public DashBoardService(MemberRepository member, MemberTypeRepository memberType, CategoryRepository category,
			BookRepository book, BookIssueRepository bookIssue, LibrarianRepository libarian) {
		super();
		this.member = member;
		this.memberType = memberType;
		this.category = category;
		this.book = book;
		this.bookIssue = bookIssue;
		this.libarian = libarian;
	}
	
	public DashBoardModel getInfo()
	{
		DashBoardModel model = new DashBoardModel();
		model.add(new Info("member", "Thành Viên",this.member.count()))
		.add(new Info("member-type", "Loại Thành Viên",this.memberType.count()))
		.add(new Info("book-issue", "Mượn Sách", this.bookIssue.count()))
		.add(new Info("category", "Thể Loại",this.category.count()))
		.add(new Info("libarian", "Thủ Thư",this.libarian.count()))
		.add(new Info("book", "Sách",this.book.count()))
		;
		return model;
	}

	
}
