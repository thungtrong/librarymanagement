package com.tdtu.ktcn.librarymanagement.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Book {
	@Id
	@SequenceGenerator(name="book_id_pk",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "book_id_pk")
	private Integer id;
	private String title;
	private String authors;
	private String tag;
	private Boolean status;
	private Integer typeDocument;
	private String publisher;
	private String img;

	@ManyToOne
	@JoinColumn(name = "language_id", foreignKey = @ForeignKey(name="book_language_id_fk"))
	private Language language;
	
	@ManyToOne
	@JoinColumn(name = "category_id", foreignKey = @ForeignKey(name="book_category_id_fk"))
	private Category category; 
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(Integer id, String title, String authors, String tag, Boolean status, Integer typeDocument,
			String publisher, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.authors = authors;
		this.tag = tag;
		this.status = status;
		this.typeDocument = typeDocument;
		this.publisher = publisher;
		this.category = category;
	}
	

	public Book(Integer id, String title, String authors, String tag, Boolean status, Integer typeDocument,
			String publisher, String img, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.authors = authors;
		this.tag = tag;
		this.status = status;
		this.typeDocument = typeDocument;
		this.publisher = publisher;
		this.img = img;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Integer getTypeDocument() {
		return typeDocument;
	}

	public void setTypeDocument(Integer typeDocument) {
		this.typeDocument = typeDocument;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	
	
}
