package com.example.project.controller;

import java.util.List;

import com.example.project.domain.Customer;
import com.example.project.domain.Order;
import com.example.project.service.OrderService;
import com.example.project.service.CustomerService;
import com.example.project.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping(value = "/list")
	public ResponseEntity<List<Order>> list() {
		return ResponseEntity.ok(orderService.list());
	}
/* 
	@GetMapping(value = "/list/{id}")
	public ResponseEntity<Order> getById(@PathVariable Integer id) {
		return ResponseEntity.ok(mapper.toDto(orderService.findById(id)));
	} */
}