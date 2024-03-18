package com.evnt.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "accounts")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String username;
	@NotBlank(message = "Không được để trống")
	private String email;
	@NotBlank(message = "Không được để trống")
	private String password;
	private int status;
	private String wl;
	
	@JsonIgnore
	@OneToMany(mappedBy = "accounts")
	List<Order> orders;

	@JsonIgnore
	@OneToMany(mappedBy = "accounts", fetch = FetchType.EAGER)
	List<Authority> authorities;
}	
