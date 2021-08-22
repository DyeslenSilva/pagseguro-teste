package br.com.teste.pagseguro.model;

import java.beans.JavaBean;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@Entity(name = "arquivo")
@AllArgsConstructor
@NoArgsConstructor
public class Arquivo  implements Serializable{

	@Id
	private String codigo;
	@Column
	private String acao;
	@Column
	private Integer quantidadeTeorica;
	@Column
	private Double participacao;
	
}
