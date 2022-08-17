package com.tdtu.ktcn.librarymanagement.model;

import javax.persistence.Column;
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
	private Integer typeDocument;
	private String language;
	private String publisher;
	private String description;
	
	@Column(columnDefinition = "varchar(255) default '/images/default.jpg'")
	private String img;

	
	@ManyToOne
	@JoinColumn(name = "category_id", foreignKey = @ForeignKey(name="book_category_id_fk"))
	private Category category; 
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(Integer id, String title, String authors, String tag, Integer typeDocument,
			String publisher, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.authors = authors;
		this.tag = tag;
		this.typeDocument = typeDocument;
		this.publisher = publisher;
		this.category = category;
	}
	

	public Book(Integer id, String title, String authors, String tag, Integer typeDocument,
			String publisher, String img, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.authors = authors;
		this.tag = tag;
		this.typeDocument = typeDocument;
		this.publisher = publisher;
		this.img = img;
		this.category = category;
	}
	
	

	public Book(Integer id, String title, String authors, String tag, Boolean status, Integer typeDocument,
			String language, String publisher, String description, String img, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.authors = authors;
		this.tag = tag;
		this.typeDocument = typeDocument;
		this.language = language;
		this.publisher = publisher;
		this.description = description;
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

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", authors=");
		builder.append(authors);
		builder.append(", tag=");
		builder.append(tag);
		builder.append(", typeDocument=");
		builder.append(typeDocument);
		builder.append(", language=");
		builder.append(language);
		builder.append(", publisher=");
		builder.append(publisher);
		builder.append(", description=");
		builder.append(description);
		builder.append(", img=");
		builder.append(img);
		builder.append(", category=");
		builder.append(category);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
