package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ArquivosController implements IArquivosController {

	@Override
	public void verificarDirTemp() throws IOException {
		// TODO Auto-generated method stub
		File dir = new File("C:\\TEMP");
		if (dir.exists() && dir.isDirectory()) {
			System.out.println("O diretório ja existe!");
		} else {
			dir.mkdir();
		}
	}

	@Override
	public boolean verificaRegistro(String arquivo, int codigo) throws IOException {
		// TODO Auto-generated method stub
		File arq = new File(arquivo);
		if (!arq.exists()) {
			System.out.println("Arquivo inválido");
		} else {
			BufferedReader br = new BufferedReader(new FileReader(arq));
			String linha = br.readLine();
			if (linha.equals("")) {
				return false;
			} else {
				while (linha != null) {
					String[] fields = linha.split(";");
					int codigocsv = Integer.parseInt(fields[0]);
					if (codigocsv == codigo) {
						return true;

					}
					linha = br.readLine();

				}
				br.close();
			}
		}
		return false;
	}

	@Override
	public void imprimeCadastro(String arquivo, int codigo) throws IOException {
		// TODO Auto-generated method stub

		File arq = new File(arquivo);
		if (verificaRegistro(arquivo, codigo) == true) {
			BufferedReader br = new BufferedReader(new FileReader(arq));
			String linha = br.readLine();
			while (linha != null) {
				String[] fields = linha.split(";");
				int codigocsv = Integer.parseInt(fields[0]);
				System.out.println("Codigo: " + codigocsv);
				String nome = fields[1];
				System.out.println("Nome:" + nome);
				String email = fields[2];
				System.out.println("email: " + email);
				linha = br.readLine();
			}
			br.close();
		}

	}

	@Override
	public void insereCadastro(String arquivo, int codigo, String nome, String email) throws IOException {
		// TODO Auto-generated method stub
		File arq = new File(arquivo);
		if (arq.exists() && arq.isFile()) {
			boolean existe = true;
			if (verificaRegistro(arquivo, codigo) == false) {
				FileWriter fw = new FileWriter(arq, existe);
				PrintWriter pw = new PrintWriter(fw);
				pw.write(String.valueOf(codigo) + ";" + nome + ";" + email);
				pw.flush();
				pw.close();
				fw.close();

			} else {
				System.out.println("pessoa ja cadastrada!");
			}
		} else {
			System.out.println("Arquivo invalido!");
		}
	}

}
