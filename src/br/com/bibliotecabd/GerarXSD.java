package br.com.bibliotecabd;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.stream.StreamResult;

import br.com.bibliotecabd.model.*;

public class GerarXSD {
	
	public void gerarXsdEditora() throws JAXBException, IOException {
		FileWriter writer = new FileWriter(".\\XSD\\Emprestimo.xsd");		
		JAXBContext jc = JAXBContext.newInstance(Emprestimo.class);
        jc.generateSchema(new SchemaOutputResolver() {        	 
            @Override
            public javax.xml.transform.Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
                StreamResult result = new StreamResult(writer);                
                result.setSystemId(suggestedFileName);
                return result;
            }

        });
	}
	
	public void gerarXsdAutor() throws JAXBException, IOException {
		FileWriter writer = new FileWriter(".\\XSD\\Autor.xsd");		
		JAXBContext jc = JAXBContext.newInstance(Autor.class);
        jc.generateSchema(new SchemaOutputResolver() {        	 
            @Override
            public javax.xml.transform.Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
                StreamResult result = new StreamResult(writer);                
                result.setSystemId(suggestedFileName);
                return result;
            }

        });
	}
	
	
	public void gerarXsdLeitor() throws JAXBException, IOException {
		FileWriter writer = new FileWriter(".\\XSD\\Leitor.xsd");		
		JAXBContext jc = JAXBContext.newInstance(Leitor.class);
        jc.generateSchema(new SchemaOutputResolver() {        	 
            @Override
            public javax.xml.transform.Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
                StreamResult result = new StreamResult(writer);                
                result.setSystemId(suggestedFileName);
                return result;
            }

        });
	}
	
	
	public void gerarXsdLivro() throws JAXBException, IOException {
		FileWriter writer = new FileWriter(".\\XSD\\Livro.xsd");		
		JAXBContext jc = JAXBContext.newInstance(Livro.class);
        jc.generateSchema(new SchemaOutputResolver() {        	 
            @Override
            public javax.xml.transform.Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
                StreamResult result = new StreamResult(writer);                
                result.setSystemId(suggestedFileName);
                return result;
            }

        });
	}
	
	

}
