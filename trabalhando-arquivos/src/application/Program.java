package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		//Buscando arquivo local com arquivo no parâmetro.
		File file = new File("C:\\Users\\Alexandre\\Documents\\apresentação");

		Scanner sc = null;
		try {
		//Modo de leitura usando classe Scanner.
			sc = new Scanner(file);
		//Testa se há uma nova linha, caso exista, imprime a mesma.
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		//Exception de erro de entrada ou saída.
		} catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
			
		} finally {
		//Se "sc" for diferente de nulo, executa o fechamento do Scanner(sc.close()).
			if(sc != null) {
			sc.close();
			}
		}
	}

}
