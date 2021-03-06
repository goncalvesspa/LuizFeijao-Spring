package com.example.project.controller;

import java.util.List;

import com.example.project.domain.Customer;
import com.example.project.domain.Supplier;
import com.example.project.service.CustomerService;
import com.example.project.service.SupplierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	@GetMapping(value = "/list")
	public ResponseEntity<List<Supplier>> list() {
		return ResponseEntity.ok(supplierService.list());
	}
	
	@GetMapping(value = "/list/{id}")
    public ResponseEntity<Supplier> list(@PathVariable Integer id) {
        return ResponseEntity.ok(supplierService.findById(id));
	}
	
}