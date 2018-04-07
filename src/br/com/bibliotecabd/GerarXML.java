package br.com.bibliotecabd;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;



import br.com.bibliotecabd.model.*;

public class GerarXML {
	
	public void gerarXmlEditora(Emprestimo editora) throws JAXBException, IOException{
		JAXBContext jContext = JAXBContext.newInstance(Emprestimo.class);
		Marshaller marshal = jContext.createMarshaller();
		FileWriter writer = new FileWriter(".\\XML\\Emprestimo.xml");
		marshal.marshal(editora, writer);
		System.out.println("Gerador o XML da Emprestimo");
	}
	
	public void gerarXmlLivro(Livro livro) throws JAXBException, IOException{
		JAXBContext jContext = JAXBContext.newInstance(Livro.class);
		Marshaller marshal = jContext.createMarshaller();
		FileWriter writer = new FileWriter(".\\XML\\Livro.xml");
		marshal.marshal(livro, writer);
		System.out.println("Gerador o XML do Livro");
	}
	
	public void gerarXmlLeitor(Leitor leitor) throws JAXBException, IOException{
		JAXBContext jContext = JAXBContext.newInstance(Leitor.class);
		Marshaller marshal = jContext.createMarshaller();
		FileWriter writer = new FileWriter(".\\XML\\Leitor.xml");
		marshal.marshal(leitor, writer);
		System.out.println("Gerador o XML do Leitor");
	}
	
	public void gerarXmlAutor(Autor autor) throws JAXBException, IOException{
		JAXBContext jContext = JAXBContext.newInstance(Autor.class);
		Marshaller marshal = jContext.createMarshaller();
		FileWriter writer = new FileWriter(".\\XML\\Autor.xml");
		marshal.marshal(autor, writer);
		System.out.println("Gerador o XML do Autor");
	}
	

}
