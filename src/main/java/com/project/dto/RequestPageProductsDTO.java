package com.project.dto;

public class RequestPageProductsDTO {
	int page;
	int size;
	String category;

	public RequestPageProductsDTO(int page, int size, String category) {
		this.page = page;
		this.size = size;
		this.category = category;
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
}
