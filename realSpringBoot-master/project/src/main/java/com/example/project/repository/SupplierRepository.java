package com.example.project.repository;

import com.example.project.domain.Customer;
import com.example.project.domain.Supplier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {    
}