package br.com.teste.pagseguro.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.pagseguro.files.ReadTXTFile;
import br.com.teste.pagseguro.model.Arquivo;

public interface ArquivoRepo extends JpaRepository<ReadTXTFile, String>{


}
