package com.evnt.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Data
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private int orderStatus;
	@Temporal(TemporalType.DATE)
	@Column(name = "createDate")
	Date createDate = new Date();
	
    @ManyToOne
    @JoinColumn(name = "acc_user")
    Account account;
    
    @JsonIgnore
	@OneToMany(mappedBy = "order")
	List<OrderDetail> orderDetails;

}
