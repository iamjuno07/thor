package com.xworkz.myfirstproject.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Setter
@Getter
@Entity
@Table(name = "XWORKZ_TABLE")
@NamedQueries({
		@NamedQuery(name = "validateLoginEmail", query = "select count(*) from LoginEntity dto where dto.email =:email"),
		@NamedQuery(name = "getUser", query = "from SignUpEntity dto where dto.email =:email"),
		@NamedQuery(name = "UpdateLoginCount", query = "update SignUpEntity dto set dto.loginCount =:value where dto.email =:email") })
public class LoginEntity implements Serializable {

	public LoginEntity() {
		System.out.println("Created" + this.getClass().getSimpleName());
	}

	@Id
	@Column(name = "ID")
	private int id;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PASSWORD")
	private String password;

}
