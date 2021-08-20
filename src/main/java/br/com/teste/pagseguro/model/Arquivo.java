package br.com.teste.pagseguro.model;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.Data;

@Data
public class Arquivo {

	@Id
	private String codigo;
	@Column
	private String acao;
	@Column
	private Integer quantidadeTeorica;
	@Column
	private Double participacao;
	
}
