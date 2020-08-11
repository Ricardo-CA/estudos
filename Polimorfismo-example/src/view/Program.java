package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of employees: ");
		int n = sc.nextInt();
		List<Employee> list = new ArrayList<>();

		for (int i = 1; i <= n; i++) {

			System.out.println("Employee #" + i + " Data:");
			System.out.print("outsourced (y/n)? ");
			char resp = sc.next().charAt(0);
			if (resp == 'y') {

				System.out.print("Name: ");
				String name = sc.next();
				System.out.print("Hours: ");
				int hours = sc.nextInt();
				System.out.print("Value per hours: ");
				Double valuePerHours = sc.nextDouble();
				System.out.print("Additional charge: ");
				Double additionalCharge = sc.nextDouble();
				Employee emp = new OutsourcedEmployee(name, hours, valuePerHours, additionalCharge);
				list.add(emp);
			} else {

				System.out.print("Name: ");
				String name = sc.next();
				System.out.print("Hours: ");
				int hours = sc.nextInt();
				System.out.print("Value per hours: ");
				Double valuePerHours = sc.nextDouble();
				Employee emp = new Employee(name, hours, valuePerHours);
				list.add(emp);
			}
			
		}
		
		System.out.println("PAYMENTS:");
		for (Employee emp : list) {
			System.out.println(emp.getName() + " - $ " + emp.payment());
		}
		

		
		sc.close();
	}

}
