package application;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.entities.Client;
import model.entities.Order;
import model.entities.Orderitem;
import model.entities.Product;
import model.enums.statusOrder;

public class Principal {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter client data:");
		System.out.print("Name:");
		String name = sc.nextLine();
		
		
		System.out.print("Email:");
		String email = sc.next();
				
		System.out.print("Birth date (dd/MM/yyyy):");
		Date birthDate =  sdf1.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data:");
		
		System.out.print("Status:");
		statusOrder status = statusOrder.valueOf(sc.next().toUpperCase());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order?");
		int N = sc.nextInt();
		
		for(int i = 1;i <= N;i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name:");
			String productName = sc.next();
			
			
			System.out.print("Product price:");
			Double productPrice = sc.nextDouble();
			
			Product product = new Product(productName, productPrice);
			
			System.out.println("Quantity:");
			int quantity = sc.nextInt();
			
			Orderitem orderitem = new Orderitem(quantity, productPrice, product);
			
			order.addItem(orderitem);
		}
		sc.close();
		
		System.out.println("");
		System.out.println("ORDER SUMMARY:");	
		System.out.println(order);
	}

}
