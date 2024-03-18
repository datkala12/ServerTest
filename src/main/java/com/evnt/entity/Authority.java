package com.evnt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.evnt.entity.Account;
import com.evnt.entity.Authority;
import com.evnt.entity.Role;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Authorities", uniqueConstraints = 
{ @UniqueConstraint(columnNames = { "acc_user", "role_id" }) })
public class Authority {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "acc_user")
	private Account account;
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
}
