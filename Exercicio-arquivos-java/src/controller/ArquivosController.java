package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class ArquivosController implements IArquivosController {

	public ArquivosController() {

	}

	public void readDir(String path) throws IOException {
		// TODO Auto-generated method stub
		File dir = new File(path);
		if (dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (File f : files) {
				if (f.isFile()) {
					System.out.println("     \t" + f.getName());
				} else {
					System.out.println("<Dir>\t" + f.getName());
				}
			}
		} else {
			throw new IOException("Diretório inválido");
		}
	}

	public void createFile(String path, String nome) throws IOException {
		// TODO Auto-generated method stub
		File dir = new File(path);
		File arq = new File(path, nome + ".csv");
		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
			}
			String conteudo = geraTxt();
			FileWriter fw = new FileWriter(arq, existe);
			PrintWriter pw = new PrintWriter(fw);
			pw.write(conteudo);
			pw.flush();
			pw.close();
			fw.close();
		} else {
			throw new IOException("Diretório inválido");
		}

	}

	private String geraTxt() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		String linha = "";
		while (!linha.equalsIgnoreCase("fim")) {
			linha = JOptionPane.showInputDialog(null, "Digite uma frase", "entrada de texto",
					JOptionPane.INFORMATION_MESSAGE);
			if (!linha.equalsIgnoreCase("fim")) {
				sb.append(linha);
			}
		}
		return sb.toString();
	}

	public void readFile(String path, String nome) throws IOException {
		// TODO Auto-generated method stub
		File arq = new File(path, nome);
		if(arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader br = new BufferedReader(leitor);
			
			String linha = br.readLine();
			while (linha != null) {
				boolean existe = false;
				System.out.println(linha);
				String content = linha + ";";
				File arqnovo = new File("C:\\TEMP","teste.csv");
				if (arqnovo.exists() && arqnovo.isFile()) {
					 existe = true;
				}
				FileWriter fw = new FileWriter(arqnovo,existe);
				PrintWriter pw = new PrintWriter(fw);
				pw.write(content);
				pw.flush();
				pw.close();
				fw.close();
				linha = br.readLine();
			}
			br.close();
			leitor.close();
			fluxo.close();
			
		} else {
			throw new IOException("Arquivo inválido!");
		}

	}

	

	public void openFile(String path, String nome) throws IOException {
		// TODO Auto-generated method stub

	}

}
