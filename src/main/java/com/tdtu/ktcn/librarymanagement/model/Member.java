package com.tdtu.ktcn.librarymanagement.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class Member {
	@Id
	@SequenceGenerator(name = "member_id_pk", allocationSize = 1)
	@GeneratedValue(generator = "member_id_pk", strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String firstName;
	private String lastName;
	private Boolean gender;
	private Date dateOfBirth;
	private String contact;
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "member_type_id", foreignKey = @ForeignKey(name="member_member_type_id_fk"))
	private MemberType memberType;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(Integer id, String firstName, String lastName, Boolean gender, Date dateOfBirth, String contact,
			String email, MemberType memberType) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.contact = contact;
		this.email = email;
		this.memberType = memberType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MemberType getMemberType() {
		return memberType;
	}

	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}
	
}
