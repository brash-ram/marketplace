package com.project.service;

import com.project.dto.*;
import com.project.entity.Product;
import com.project.entity.User;
import com.project.repository.ProductRepository;
import com.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	UserRepository userRepository;

	public ResponsePageProductDTO loadPage(RequestPageProductsDTO page){
		List<Product> products = productRepository.findAll();
		List<LowFieldProductDTO> lowFieldProducts = new ArrayList<>();

		for (Product product : products.subList( page.getPage(), (page.getPage()+page.getSize())) ){
			lowFieldProducts.add(new LowFieldProductDTO(product.getName(), product.getPrice()));
		}
		return new ResponsePageProductDTO(page.getPage(), page.getSize(),
				page.getCategory(), lowFieldProducts);
	}

	public ProductDTO loadProduct(long idProduct) {
		Product product = productRepository.findById(idProduct);
		User user = userRepository.findById(product.getIdUser());

		return new ProductDTO(product.getId(), product.getCategory(), product.getName(),
				product.getDescription(), product.getPrice(), "user.getFio()", "user.getEmail()");

	}

	public boolean addProduct(Product product) {
		try {
			productRepository.save(product);
		}
		catch (Exception ex) {
			return false;
		}
		return true;
	}
}
