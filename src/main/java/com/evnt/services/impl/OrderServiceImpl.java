package com.evnt.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.evnt.entity.Order;
import com.evnt.entity.OrderDetail;
import com.evnt.repo.OrderDetailRepo;
import com.evnt.repo.OrderRepo;
import com.evnt.services.OrderService;
import com.fasterxml.jackson.core.type.TypeReference;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired private OrderRepo orepo;
	@Autowired private OrderDetailRepo odrepo;
	@Override
	public Order create(JsonNode orderData) {
		ObjectMapper mapper = new ObjectMapper();
		
		Order order = mapper.convertValue(orderData, Order.class);
		orepo.save(order);
		
		TypeReference<List<OrderDetail>> type = new TypeReference<>() {};
		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type)
				.stream().peek(d->d.setOrder(order)).collect(Collectors.toList());
		odrepo.saveAll(details);
		
		return order;
	}
	@Override
	public Order findById(Long id) {
		return orepo.findById(id).get();
	}
	
	@Override
	public List<Order> findByUsername(String username) {
		return orepo.findByUsername(username);
	}
}
