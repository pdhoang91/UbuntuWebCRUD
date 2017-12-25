package tma.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="order")
public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String orderId;
	
	private String productName;

	private int quantity;
	
	public Order(){
		
	}
	
	public Order(String orderId, String productName, int quantity) {
	super();
	this.orderId = orderId;
	this.productName = productName;
	this.quantity = quantity;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productName=" + productName + ", quantity=" + quantity + "]";
	}
}