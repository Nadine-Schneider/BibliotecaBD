package br.com.bibliotecabd;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.bibliotecabd.model.Autor;
import br.com.bibliotecabd.model.Emprestimo;
import br.com.bibliotecabd.model.Leitor;
import br.com.bibliotecabd.model.Livro;

public class GerarJSON {
	
	public void gerarJsonAutor(ArrayList<Autor> autor) throws JAXBException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		FileWriter arquivoAutor = new FileWriter(".\\BibliotecaBD\\JSON\\Autor.json");
		mapper.writeValue(arquivoAutor, autor);	
		System.out.println("Gerador o JSON");
	}
	
	public void gerarJsonLivro(ArrayList<Livro> livro) throws JAXBException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		FileWriter arquivoLivro = new FileWriter(".\\BibliotecaBD\\JSON\\Livro.json");
		mapper.writeValue(arquivoLivro, livro);
	}
	
	public void gerarJsonLeitor(ArrayList<Leitor> leitor) throws JAXBException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		FileWriter arquivoLeitor = new FileWriter(".\\BibliotecaBD\\JSON\\Leitor.json");
		mapper.writeValue(arquivoLeitor, leitor);
	}
	
	public void gerarJsonEmprestimo(ArrayList<Emprestimo> emprestimo) throws JAXBException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		FileWriter arquivoLeitor = new FileWriter(".\\BibliotecaBD\\JSON\\Emprestimo.json");
		mapper.writeValue(arquivoLeitor, emprestimo);
	}
	
	
}
