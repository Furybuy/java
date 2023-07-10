package entities;

import java.util.ArrayList;
import java.util.List;

public class OrderItem {
	
	private Integer quantity;
	private double price;
	private List<Product> product = new ArrayList<>();
	
	public OrderItem(Integer quantity, double price) {
		this.quantity = quantity;
		this.price = price;
	}

	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public double getPrice() {
		return price;
	}
	
	public String getName() {
		for (Product products: product) {
			if (products.getPrice() == price) {
				return products.getName();
			}
		}
		return null;
	}
	
	public double subTotal () {
		return quantity * price;
	}
}
