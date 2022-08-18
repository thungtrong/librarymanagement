package com.tdtu.ktcn.librarymanagement.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class BookIssue {
	
	@Id
	@SequenceGenerator(name="book_issue_id_pk", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="book_issue_id_pk")
	private Long id;
	@JsonFormat(pattern=DatePattern.DEFAULT)
	private Date dateStart;
	@JsonFormat(pattern=DatePattern.DEFAULT)
	private Date dateEnd;
	private String note;
	private Boolean status; // True - Da tra; False - chau tra
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "book_issue_detail",
	joinColumns = @JoinColumn(name="book_issue_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="book_id", referencedColumnName="id")
	)
	private List<Book> books = new ArrayList<>();
	
	@ManyToOne
	private Member member;
	
	@ManyToOne
	private Librarian librarian;
	
	public BookIssue() {
		// TODO Auto-generated constructor stub
	}

	public BookIssue(Long id, Date dateStart, Date dateEnd, String note, Boolean status, List<Book> books, Member member,
			Librarian librarian) {
		super();
		this.id = id;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.note = note;
		this.status = status;
		this.books = books;
		this.member = member;
		this.librarian = librarian;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Librarian getLibrarian() {
		return librarian;
	}

	public void setLibrarian(Librarian librarian) {
		this.librarian = librarian;
	}
	
	
}
