package view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Insira o caminho do arquivo: ");
		String path = sc.next();
		System.out.println("insira o salario que deseja filtrar:");
		Double salary = sc.nextDouble();
		List<Employee> lista = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				lista.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<String> emails = lista.stream()
				.filter(x -> x.getSalary() > salary)
				.map(x -> x.getEmail())
				.sorted()
				.collect(Collectors.toList());
		System.out.println("Emails de pessoas com salario maior que: " + String.format("%.2f", salary));
		emails.forEach(System.out :: println);
		
		Double sum = lista.stream()
				.filter(e -> e.getName().toUpperCase().charAt(0) == 'M')
				.map(e -> e.getSalary())
				.reduce(0.0, (x,y) -> x + y);
		System.out.println("Soma dos salarios de pessoas que começam com a letra M:" + sum);
				
		sc.close();
	}

}
