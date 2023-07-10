package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

	private Date moment;
	private OrderStatus status;
	
	private Client client;
	
	private List<OrderItem> orderItem = new ArrayList<>();
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private SimpleDateFormat sdfBirth = new SimpleDateFormat("(dd/MM/yyyy)");
	
	public Order(Date moment, OrderStatus status) {
		this.moment = moment;
		this.status = status;
	}

	public Date getMoment() {
		return moment;
	}



	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public void addItem (OrderItem oItem) {
		orderItem.add(oItem);
	}
	
	public void removeItem (OrderItem oItem) {
		orderItem.remove(oItem);
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public double total() {
		double sum = 0;
		for (OrderItem oItem : orderItem) {
			sum += oItem.subTotal();
		}
		return sum;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY:\n");
		sb.append("Oder moment: " + sdf.format(moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append("Client: " + client.getName() + sdfBirth.format(client.getBirthday()) + " - " + client.getEmail() + "\n");
		sb.append("Order items: \n");
		for (OrderItem oItem : orderItem) {
			sb.append(oItem.getName() + ", $" + oItem.getPrice() + ", Qantity: " + oItem.getQuantity() + ", Subtotal: " + oItem.subTotal() + "\n");
	    }
		sb.append("Total proce: $" + total());
		return sb.toString();
	}
}
