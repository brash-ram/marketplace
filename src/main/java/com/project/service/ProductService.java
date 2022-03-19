package com.project.service;

import com.project.dto.*;
import com.project.entity.Product;
import com.project.entity.User;
import com.project.repository.ProductRepository;
import com.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	UserRepository userRepository;

	private int getEndIndex(RequestPageProductsDTO page, int sizeProducts) {
		int index = (page.getPage() - 1) * page.getSize() + page.getSize();
		return Math.min(index, sizeProducts);
	}

	public ResponsePageProductDTO loadPage(RequestPageProductsDTO page){
		List<Product> products = productRepository.findAll();
		List<LowFieldProductDTO> lowFieldProducts = new ArrayList<>();
		products.removeIf(product -> !product.getCategory().equals(page.getCategory()));

		if ((long) (page.getPage() - 1) * page.getSize() < products.size()) {
			int endIndex = getEndIndex(page, products.size());

			for (Product product : products.subList((page.getPage() - 1) * page.getSize(), endIndex)) {
				lowFieldProducts.add(new LowFieldProductDTO(product.getId(), product.getName(), product.getPrice()));
			}
			return new ResponsePageProductDTO(page.getPage(), page.getSize(),
					page.getCategory(), lowFieldProducts);
		}
		else {
			return null;
		}
	}

	public ProductDTO loadProduct(long idProduct) {
		Product product = productRepository.findById(idProduct);
		User user = userRepository.findById(product.getIdUser());

		return new ProductDTO(product.getCategory(), product.getName(),
				product.getDescription(), product.getPrice(), user.getFio(), user.getEmail());

	}

	public boolean addProduct(Product product, UserDetails user) {
		product.setIdUser(userRepository.findByUsername(user.getUsername()).getId());
		try {
			productRepository.save(product);
		}
		catch (Exception ex) {
			return false;
		}
		return true;
	}
}
