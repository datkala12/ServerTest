package com.evnt.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	private int id;
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "roles")
	List<Authority> authorities;
}
