package br.com.teste.pagseguro.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.teste.pagseguro.files.ReadTXTFile;
import br.com.teste.pagseguro.repo.ArquivoRepo;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.QuotesProperty;
import yahoofinance.quotes.stock.StockQuote;

@Service
@Component
@Qualifier("arquivoService")
public class ArquivoService {

	//@Autowired
	private ArquivoRepo arquivoRepo;

	
	private YahooFinance yahooFinance;
	
	public void salvarLinhas(String arquivo) throws IOException {
		 ReadTXTFile readTXTFile =  ReadTXTFile.readTXT(arquivo);
		 arquivoRepo.save(readTXTFile);
	}
	
	public List<ReadTXTFile> getAcoes(){
		return (List<ReadTXTFile>) arquivoRepo.findAll();
	}
	
	public Optional<ReadTXTFile> getAcaoPorCodigo(String codigo) {
		return (Optional<ReadTXTFile>) arquivoRepo.findById(codigo);
	}
	
	public Optional<ReadTXTFile> getAcaoPorNome(String nome) {
		return (Optional<ReadTXTFile>) arquivoRepo.findById(nome);
	}
	
	public void deleteArquivo(String codigo){
		 arquivoRepo.deleteById(codigo);
	}
	
	
	public void setActions() {
		
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public ListIterator<StockQuote> get10Actions(){
		List<StockQuote> stockQuotes = new ArrayList<>();
		for(StockQuote quote : stockQuotes) {
			if(stockQuotes.iterator().equals(quote.getDayHigh())) {
				return stockQuotes.listIterator();
			}
		}	
		 return null;
	}
}