package view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;



public class Program {

	public static void main(String[] args) {

		Map<String, Integer> voting = new LinkedHashMap<>();
		Scanner sc = new Scanner(System.in);

		System.out.println("Insira o caminho do arquivo: ");
		String path = sc.next();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				int votes = Integer.parseInt(fields[1]);
				
				if (voting.containsKey(name)) {
					int actualVotes = voting.get(name);
					voting.put(name, votes + actualVotes);
				}else {
				voting.put(name, votes);
				}
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(String key : voting.keySet()) {
			System.out.println(key +": " +  voting.get(key));
		}

		sc.close();
	}

}
