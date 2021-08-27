package br.com.teste.pagseguro.repo;

import java.beans.JavaBean;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.teste.pagseguro.files.ReadTXTFile;
import br.com.teste.pagseguro.model.Arquivo;

@Repository
public interface ArquivoRepo extends JpaRepository<ReadTXTFile, String>{
	
	Arquivo findByArquivo(String arquivo);
	ReadTXTFile readTXTFile(String read);
	Optional<ReadTXTFile> findById(String codigo);
	void deleteById(String codigo);
}
