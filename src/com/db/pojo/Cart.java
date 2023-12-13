package com.db.pojo;

public class Cart {

	private Integer cartId;
	private String email;
	private Integer productId;//foreign key references Product_6201(productId)
	private Integer quantity;
	//Product object will be able to give all details about product
	private Product product;//No need to create column for this. 
}
