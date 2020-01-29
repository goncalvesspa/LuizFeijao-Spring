package com.example.project.domain;



import java.util.Date;

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
@Table(name = "CustomerOrder")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Date orderDate;

    @Column(nullable = false, length = 10, columnDefinition = "nvarchar")
    private String orderNumber;

    @JoinColumn(name = "CustomerId", nullable = false)
    @ManyToOne
    private Customer customerId;

    @Column(nullable = false, columnDefinition = "decimal(12,2)")
    private double totalAmount;

    
}