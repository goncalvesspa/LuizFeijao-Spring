package com.example.project.repository;

import com.example.project.domain.Customer;
import com.example.project.domain.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {    
}