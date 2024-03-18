package com.evnt.services;

import org.springframework.stereotype.Service;

@Service
public interface OrderDetailService {

	Double getTodayIncome();

	Double getTotalIncome();
	
}
