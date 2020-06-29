package view;

import java.io.IOException;

import controller.ArquivosController;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArquivosController ArqCon = new ArquivosController();
		try {
			ArqCon.verificarDirTemp();
			ArqCon.insereCadastro("C:\\TEMP\\teste.csv", 1, "Ricardo", "ricorino1@gmail.com");
			ArqCon.imprimeCadastro("C:\\TEMP\\teste.csv", 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
