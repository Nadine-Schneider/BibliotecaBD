package br.com.bibliotecabd;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.bind.JAXBException;

import com.sun.javafx.collections.ArrayListenerHelper;

import br.com.bibliotecabd.model.Autor;
import br.com.bibliotecabd.model.Emprestimo;
import br.com.bibliotecabd.model.Leitor;
import br.com.bibliotecabd.model.Livro;

public class Principal {
	
	
	public static Autor a1;
	public static Autor a2;
	public static Autor a3;
	public static Autor a4;
	public static Autor a5;
	public static Autor a6;
	
	
	public static Livro livro_1;
	public static Livro livro_2;
	public static Livro livro_3;
	public static Livro livro_4;
	public static Livro livro_5;
	
	public static Leitor leitorA;
	public static Leitor leitorB;
	
	public static void setupAutor()
	{
		a1 = new Autor("Conf�cio", "da Silveira");
		a2 = new Autor("Friedrich", "Nietzsche");
		a3 = new Autor("Eduardo", "Farias");
		a4 = new Autor("Elvis", "Mercury");
		a5 = new Autor("Arist�teles", "das Neves");
		a6 = new Autor("Plat�o", "Cobre");
	}
	
	public static void setupLivros()
	{
		List<Livro> livros = new ArrayList<Livro>();
		
		livro_1 = new Livro();
		livro_1.set_titulo("Aprontando Confus�es");
		livro_1.set_dataPublicacao(converteData(15, 8, 2000));
		
		livro_1.set_autor(new ArrayList<Autor>()
		{{
			add(a1);
		}});
		livro_1.set_editora("Editora Rocco");
		livros.add(livro_1);
		
		
		livro_2 = new Livro();
		livro_2.set_titulo("Aprontando Confus�es II");
		
		livro_2.set_dataPublicacao(converteData(22, 2, 1995));
		livro_2.set_autor(new ArrayList<Autor>()
		{{
			add(a1);
			add(a2);
		}});
		livro_2.set_editora("Editora Abril");
		livros.add(livro_2);
		
		livro_3 = new Livro();
		livro_3.set_titulo("Cozinhando na Gr�cia Antiga");
		livro_3.set_dataPublicacao(converteData(12, 7, 333));
		livro_3.set_autor(new ArrayList<Autor>()
		{{
			add(a5);
			add(a6);
		}});
		livro_3.set_editora("Editora Globo");
		livros.add(livro_3);
		
		
		livro_4 = new Livro();
		livro_4.set_titulo("Top 10 Guerras para se morrer...de primeira!");
		livro_4.set_dataPublicacao(converteData(6, 6, 2002));
		livro_4.set_autor(new ArrayList<Autor>()
		{{
			add(a3);
		}});
		livro_4.set_editora("Editora Rocco");
		livros.add(livro_4);
	
		livro_5 = new Livro();
		livro_5.set_titulo("Sambando no Rock Sertanejo");
		livro_5.set_dataPublicacao(converteData(1, 2, 2010));
		livro_5.set_autor(new ArrayList<Autor>() {{
			add(a4);
		}});
		livro_5.set_editora("Editora Leya");
		livros.add(livro_5);
		
	}
	public static void setupLeitor()
	{
		leitorA = new Leitor("Jo�o", "Pereira", "51 96666 6666");
		leitorB = new Leitor("Joaquina", "Rocha", "51 98871 9876");
		
		leitorA.set_emprestimos(new ArrayList<Emprestimo>() {
			{
				add(new Emprestimo(livro_1, converteData(6, 4, 2018)));
				add(new Emprestimo(livro_2, converteData(12, 8, 2017)));
				add(new Emprestimo(livro_3, converteData(24, 3, 2013)));
			}
		});

		leitorB.set_emprestimos(new ArrayList<Emprestimo>() {
			{
				add(new Emprestimo(livro_1, converteData(5, 5, 2017)));
				add(new Emprestimo(livro_4, converteData(16, 6, 2016)));
				add(new Emprestimo(livro_5, converteData(29, 1, 2014)));
			}
		});
	}
	public static Date converteData(int dia,int mes, int ano)
	{
		Calendar c = Calendar.getInstance();
		c.set(ano, mes, dia);
		return c.getTime();
	}
	
	@SuppressWarnings("serial")
	public static void main(String[] args) throws JAXBException, IOException
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca_bd_persistence_unit");
		EntityManager em = emf.createEntityManager();
		
		
		
		
		setupAutor();
		setupLivros();
		setupLeitor();
		
		
		
		
		em.getTransaction().begin();
		
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		em.persist(a4);
		em.persist(a5);
		em.persist(a6);
		
	
		em.persist(livro_1);
		em.persist(livro_2);
		em.persist(livro_3);
		em.persist(livro_4);
		em.persist(livro_5);
		
		em.persist(leitorA);
		em.persist(leitorB);
	
		em.getTransaction().commit();
		
		
	//JSON
		
		ArrayList<Autor> autor = new ArrayList<Autor>();
		autor.add(a1);
		autor.add(a2);
		autor.add(a3);
		autor.add(a4);
		autor.add(a5);
		autor.add(a6);
		
		ArrayList<Livro> livro = new ArrayList<Livro>();
		livro.add(livro_1);
		livro.add(livro_2);
		livro.add(livro_3);
		livro.add(livro_4);
		livro.add(livro_5);
		
		ArrayList<Leitor> leitor = new ArrayList<Leitor>();
		leitor.add(leitorA);
		leitor.add(leitorB);
		
		ArrayList<Emprestimo> arrayEmprestimo = new ArrayList<Emprestimo>();
		arrayEmprestimo.add(em.find(Emprestimo.class, 1L));
		arrayEmprestimo.add(em.find(Emprestimo.class, 2L));
		arrayEmprestimo.add(em.find(Emprestimo.class, 3L));
		
		GerarJSON geradorJson = new GerarJSON();
		geradorJson.gerarJsonAutor(autor);
		geradorJson.gerarJsonLivro(livro);
		geradorJson.gerarJsonLeitor(leitor);	
		geradorJson.gerarJsonEmprestimo(arrayEmprestimo);
		
		//XML		
		
		Emprestimo emp = em.find(Emprestimo.class, 2L);
		Autor aut = em.find(Autor.class, 2L);
		Leitor lei = em.find(Leitor.class, 2L);
		Livro liv = em.find(Livro.class, 2L);
		
		GerarXML gerarXml = new GerarXML();
		gerarXml.gerarXmlEditora(emp);
		gerarXml.gerarXmlAutor(aut);
		gerarXml.gerarXmlLeitor(lei);
		gerarXml.gerarXmlLivro(liv);
		
		//XSD
		
		GerarXSD gerarXsd = new GerarXSD();
		gerarXsd.gerarXsdEditora();
		gerarXsd.gerarXsdAutor();
		gerarXsd.gerarXsdLeitor();
		gerarXsd.gerarXsdLivro();
		
		
		
		
		
		
		System.exit(0);
		
	}
	
	

}
