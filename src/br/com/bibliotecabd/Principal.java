package br.com.bibliotecabd;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
		a1 = new Autor("Confúcio", "da Silveira");
		a2 = new Autor("Friedrich", "Nietzsche");
		a3 = new Autor("Eduardo", "Farias");
		a4 = new Autor("Elvis", "Mercury");
		a5 = new Autor("Aristóteles", "das Neves");
		a6 = new Autor("Platão", "Cobre");
	}
	
	public static void setupLivros()
	{
		List<Livro> livros = new ArrayList<Livro>();
		
		livro_1 = new Livro();
		livro_1.set_titulo("Aprontando Confusões");
		livro_1.set_dataPublicacao(converteData(15, 8, 2000));
		
		livro_1.set_autor(new ArrayList<Autor>()
		{{
			add(a1);
		}});
		livro_1.set_editora("Editora Rocco");
		livros.add(livro_1);
		
		
		livro_2 = new Livro();
		livro_2.set_titulo("Aprontando Confusões II");
		
		livro_2.set_dataPublicacao(converteData(22, 2, 1995));
		livro_2.set_autor(new ArrayList<Autor>()
		{{
			add(a1);
			add(a2);
		}});
		livro_2.set_editora("Editora Abril");
		livros.add(livro_2);
		
		livro_3 = new Livro();
		livro_3.set_titulo("Cozinhando na Grécia Antiga");
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
		leitorA = new Leitor("João", "Pereira", "51 96666 6666");
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
	public static void main(String[] args)
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
		
		
		System.exit(0);
		
	}
	
	

}
