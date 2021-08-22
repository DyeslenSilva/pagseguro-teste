package br.com.teste.pagseguro.repo;

import java.beans.JavaBean;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.pagseguro.files.ReadTXTFile;
import br.com.teste.pagseguro.model.Arquivo;

@JavaBean
public interface ArquivoRepo extends JpaRepository<ReadTXTFile, String>{
	
	Arquivo findByArquivo(String arquivo);
	ReadTXTFile readTXTFile(String read);
}
