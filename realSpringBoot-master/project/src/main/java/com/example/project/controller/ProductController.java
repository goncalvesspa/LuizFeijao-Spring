package com.example.project.controller;

import java.util.List;

import com.example.project.domain.Customer;
import com.example.project.domain.Product;
import com.example.project.service.CustomerService;
import com.example.project.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@RestController
@RequestMapping("/product")
public class ProductController {

	/* @Autowired
	private UploadService uploadService; */

	@Autowired
	private ProductService productService;



	@GetMapping(value = "/list")
	public ResponseEntity<List<Product>> list() {
		return ResponseEntity.ok(productService.list());
	}

	/* @PostMapping(value = "/upload/{id}")
	public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file, @PathVariable Integer id) {
		return new ResponseEntity<>(productService.upload(file, id), HttpStatus.OK);
	} */

	@GetMapping(value = "/list/{id}")
	public ResponseEntity<List<Product>> list2() {
		return ResponseEntity.ok(productService.list());
	}	
 

	@PutMapping(value = "/upload/{id}") // atualizado para chamar o metodo de salvar a imagem no banco
    public ResponseEntity<Product> upload(@RequestParam("file") MultipartFile file, @PathVariable Integer id) {
        String s = productService.upload(file, id);
        Product p = productService.putImagem(id, s);
        return ResponseEntity.ok(p);
    }

}