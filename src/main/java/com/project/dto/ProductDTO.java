package com.project.dto;

public class ProductDTO {

	private String category;
	private String name;
	private String description;
	private long price;

	private String sellerFio;
	private String email;

	public ProductDTO(String category, String name, String description, long price, String sellerFio, String email) {
		this.category = category;
		this.name = name;
		this.description = description;
		this.price = price;
		this.sellerFio = sellerFio;
		this.email = email;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getSellerFio() {
		return sellerFio;
	}

	public void setSellerFio(String sellerFio) {
		this.sellerFio = sellerFio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
