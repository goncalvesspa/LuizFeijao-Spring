package com.example.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "ProductName",nullable = false, length = 50, columnDefinition = "nvarchar")
    private String productName;

    @JoinColumn(name = "SupplierId", nullable = false)
    @ManyToOne
    private Supplier supplierId;

    @Column(name = "UnitPrice", nullable = false, columnDefinition = "decimal(12,2)")
    private double unitPrice;

    @Column(name = "Package", nullable = false, length = 30, columnDefinition = "nvarchar")
    private String pacote;

    @Column(name = "IsDiscontinued", nullable = false, columnDefinition = "BIT")
    private Integer isDiscontinued;
}