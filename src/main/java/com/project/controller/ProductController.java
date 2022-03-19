package com.project.controller;

import com.project.dto.RequestPageProductsDTO;
import com.project.dto.ResponsePageProductDTO;
import com.project.dto.ProductDTO;
import com.project.entity.Product;
import com.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/catalog")
	public ResponsePageProductDTO getPage( RequestPageProductsDTO page) {
		return productService.loadPage(page);
	}

	@GetMapping("/catalog")
	public ProductDTO getProduct(@RequestParam("id") long idProduct) {
		return  productService.loadProduct(idProduct);
	}

	@PostMapping("/addProduct")
	public boolean addProduct( Product product, Authentication authentication) {
		return productService.addProduct(product, (UserDetails) authentication.getPrincipal());
	}
}
