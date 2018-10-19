package com.gorevtakibi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity 
public class Authority {

	@Id
	private int id;
	@NotEmpty
	private String username;
	@NotEmpty
	private String role;


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public String setRole(String role) {
		return this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
