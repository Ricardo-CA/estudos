package model.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.enums.statusOrder;

public class Order {

	private Date momment = new Date();
	private statusOrder status;
	private Client client;
	
	private List<Orderitem> list1 = new ArrayList<>();
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	
	public Order(Date momment, statusOrder status, Client client) {
		this.momment = momment;
		this.status = status;
		this.client = client;
	}
	
	public Date getMomment() {
		return momment;
	}

	public void setMomment(Date momment) {
		this.momment = momment;
	}

	public statusOrder getStatus() {
		return status;
	}

	public void setStatus(statusOrder status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Orderitem> getList1() {
		return list1;
	}

	public void addItem(Orderitem item) {
		list1.add(item);
	}
	public void removeItem(Orderitem item) {
		list1.remove(item);
	}
	
	public Double total() {
		double total = 0.0;
		for (Orderitem item : list1) {
			total+= item.subTotal();
		}
		return total;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment:");
		sb.append(sdf.format(momment) + "\n");
		sb.append("Order status:");
		sb.append(status + "\n");
		sb.append("Client:");
		sb.append(client + "\n");
		sb.append("Order items:\n");
		for (Orderitem item : list1) {
			sb.append(item + "\n");
		}
		sb.append("Total price:");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
	
}