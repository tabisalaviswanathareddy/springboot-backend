package net.javaguides.springboot.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.Date;

@Document(collection="product")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
@Scope(value ="session")
@Component
public class Product {
	@Transient
	public static final String SEQUENCE_NAME = "product_sequence";
	@Id
	@Indexed(unique = true)
	private int id;



	private String productCode;

	private String productName;

	private double price;

	private double tax;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product(String productCode, String productName, double price, double tax) {
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
		this.tax = tax;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
}
