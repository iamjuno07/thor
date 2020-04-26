package com.xworkz.myfirstproject.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
@Entity
@Table(name = "XWORKZ_TABLE")
@NamedQueries({ @NamedQuery(name = "validateUsername", query = "from SignUpEntity dto where dto.username =:username"),
		@NamedQuery(name = "validateEmail", query = "from SignUpEntity dto where dto.email =:email") })
public class SignUpEntity implements Serializable {

	public SignUpEntity() {
		System.out.println("Created" + this.getClass().getSimpleName());
	}

	@Id
	@GenericGenerator(name = "ref", strategy = "increment")
	@GeneratedValue(generator = "ref")
	@Column(name = "ID")
	private int id;
	@Column(name = "USERNAME")
	private String username;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PHONE")
	private String phone;
	@Column(name = "COURSE")
	private String course;
	@Column(name = "LOGIN_COUNT")
	private int loginCount;

}
