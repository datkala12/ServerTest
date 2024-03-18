package com.evnt.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evnt.repo.OrderDetailRepo;
import com.evnt.services.OrderDetailService;
import com.evnt.util.XDate;



@Service
public class OrderDetailServiceImpl implements OrderDetailService{

	@Autowired private OrderDetailRepo dtrepo;
	@Autowired private XDate xdate;
	
	@Override
	public Double getTodayIncome() {
		return dtrepo.findAll().stream().filter(e->e.getOrder().getCreateDate().toString().equals(xdate.convertToPattern(new Date(), "yyyy-MM-dd"))).mapToDouble(item->item.getPrice()).sum();
	}
	@Override
	public Double getTotalIncome() {
		return dtrepo.findAll().stream().mapToDouble(item->item.getPrice()).sum();
	}

}
