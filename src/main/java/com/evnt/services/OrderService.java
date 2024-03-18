package com.evnt.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.evnt.entity.Order;
import com.fasterxml.jackson.databind.JsonNode;


@Service
public interface OrderService {
	Order create(JsonNode orderData);

	Order findById(Long id);

	List<Order> findByUsername(String username);
}
