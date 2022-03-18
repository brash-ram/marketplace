package com.project.dto;

import java.util.List;

public class ResponsePageProductDTO {
	int page;
	int size;
	String category;
	List<LowFieldProductDTO> products;

	public ResponsePageProductDTO(int page, int size, String category, List<LowFieldProductDTO> products) {
		this.page = page;
		this.size = size;
		this.category = category;
		this.products = products;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<LowFieldProductDTO> getProducts() {
		return products;
	}

	public void setProducts(List<LowFieldProductDTO> products) {
		this.products = products;
	}
}
