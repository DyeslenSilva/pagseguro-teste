package br.com.teste.pagseguro.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadTXTFile {

	public static ReadTXTFile readTXT(String arquivo) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(arquivo));
		String linha ="";
		
		ReadTXTFile arquivoFle = null;
		
		while(true) {
			if(linha != null) {
				System.out.println(linha);
			}else break;
			
			linha = bufferedReader.readLine();
		}
		
		bufferedReader.close();
		return arquivoFle;
	
	}
}
