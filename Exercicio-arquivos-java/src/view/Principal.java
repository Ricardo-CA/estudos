package view;

import java.io.IOException;

import controller.ArquivosController;
import controller.IArquivosController;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IArquivosController arqCont = new ArquivosController();
		
		try {
			//arqCont.readDir(dirWin);
			arqCont.readFile("C:\\", "relatorio.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
