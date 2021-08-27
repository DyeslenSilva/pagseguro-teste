package br.com.teste.pagseguro.cotroller;

import java.beans.JavaBean;
import java.io.IOException;
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.pagseguro.model.Arquivo;
import br.com.teste.pagseguro.service.ArquivoService;

@SuppressWarnings("serial")
@RestController()
@RequestMapping("/arquivo")
//@Component
//@Qualifier("arquivoController")
public class ArquivoController implements Serializable{

	//@Autowired
	private ArquivoService arquivoService;
	
	@RequestMapping(value = "/salvarArquivo", method = RequestMethod.POST)
	public ResponseEntity<?> salveArquivos(@PathVariable String arquivo,
			BindingResult bindingResult) throws IOException{	
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}else {
			arquivoService.salvarLinhas(arquivo);
			return ResponseEntity.ok().build();
		}
	}
	
	@RequestMapping(value = "/acoes", method = RequestMethod.GET)
	public ResponseEntity<?> listaAcoes(BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}else {
			arquivoService.getAcoes();
			return ResponseEntity.accepted().build();
		}
	}
	
	@RequestMapping(value = "/acao/{codigoAcao}", method = RequestMethod.GET)
	public ResponseEntity<?> listaAcaoPorCodigo(@PathVariable String codigoAcao,
			BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}else {
			arquivoService.getAcaoPorCodigo(codigoAcao);
			return ResponseEntity.ok().build();
		}
	
	}
	
	@RequestMapping(value = "/acao/{nomeDaAcao}" , method = RequestMethod.GET)
	public ResponseEntity<?> listaAcaoPorNome(@PathVariable String nomeDaAcao,
			BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}else {
			arquivoService.getAcaoPorNome(nomeDaAcao);
			return ResponseEntity.ok().build();
		}
		
	}
	
	@RequestMapping(value = "/acao/{codigoDaAcao}" , method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAcao(@PathVariable String codigoDaAcao,
			BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}else {
			arquivoService.deleteArquivo(codigoDaAcao);
			return ResponseEntity.ok().build();
		}
	
	}
	
	@RequestMapping(value = "/acao/{10maioresAcoes}" , method = RequestMethod.GET)
	public ResponseEntity<?> lista10Acoes(BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}else {
			arquivoService.get10Actions();
			return ResponseEntity.ok().build();
		}
	}
	
	
}
