package net.javaguides.springboot.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Document(collection="invoice")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
@Scope(value ="session")
@Component
public class Invoice {
	@Transient
	public static final String SEQUENCE_NAME = "invoice_sequence";
	@Id
	@Indexed(unique = true)
	private int id;


	private String customerName;


	private String deliveryAddress;

	private String billingAddress;

	private String mobileNo;

	private String billingDate;

	private List<ProductDetails> details;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public List<ProductDetails> getDetails() {
		return details;
	}

	public void setDetails(List<ProductDetails> details) {
		this.details = details;
	}

	public String getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(String billingDate) {
		this.billingDate = billingDate;
	}
}
