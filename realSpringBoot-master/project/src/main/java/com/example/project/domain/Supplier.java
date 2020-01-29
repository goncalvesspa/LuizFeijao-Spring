package com.example.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "CompanyName",nullable = false, length = 40, columnDefinition = "nvarchar")
    private String CompanyName;

    @Column(name = "ContactName",nullable = false, length = 50, columnDefinition = "nvarchar")
    private String ContactName;
    
    @Column(name = "ContactTitle",nullable = false, length = 40, columnDefinition = "nvarchar")
    private String ContactTitle;

    @Column(name = "City",nullable = false, length = 40, columnDefinition = "nvarchar")
    private String City;

    @Column(name = "Country",nullable = false, length = 40, columnDefinition = "nvarchar")
    private String Country;

    @Column(name = "Phone",nullable = false, length = 30, columnDefinition = "nvarchar")
    private String Phone;

    @Column(name = "Fax",nullable = false, length = 30, columnDefinition = "nvarchar")
    private String Fax;
}