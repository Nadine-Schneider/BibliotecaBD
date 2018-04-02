package br.com.bibliotecabd;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bibliotecabd.model.Autor;
import br.com.bibliotecabd.model.Editora;
import br.com.bibliotecabd.model.Leitor;
import br.com.bibliotecabd.model.Livro;

public class Principal {
	
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca_bd_persistence_unit");
		EntityManager em = emf.createEntityManager();
		
		
		Calendar c = Calendar.getInstance();
		
		Autor a1 = new Autor("Renan", "Silva");
		Autor a2 = new Autor("Eduardo", "Farias");
		Autor a3 = new Autor("Zeca", "Soares");
		Autor a4 = new Autor("Aristóteles", "das Neves");
		
		Editora e1 = new Editora("Editora Rocco");
		Editora e2 = new Editora("Editora Abril");
		
		List<Livro> livros = new ArrayList<Livro>();
		
		Livro livro_1 = new Livro();
		livro_1.set_nome("Aprontando Travessuras");
		c.set(2000, 8, 15);
		livro_1.set_dataPublicacao(c.getTime());
		livro_1.set_autor(a1);
		livro_1.set_editora(e2);
		livros.add(livro_1);

		Livro livro_2 = new Livro();
		livro_2.set_nome("Aprontando Travessuras II");
		c.set(1995, 2, 22);
		livro_2.set_dataPublicacao(c.getTime());
		livro_2.set_autor(a1);
		livro_2.set_editora(e2);
		livros.add(livro_2);
		
		
		Livro livro_3 = new Livro();
		livro_3.set_nome("Cozinhando na Grécia Antiga");
		c.set(333, 7, 12);
		livro_3.set_dataPublicacao(c.getTime());
		livro_3.set_autor(a4);
		livro_3.set_editora(e1);
		livros.add(livro_3);
		
		
		Livro livro_4 = new Livro();
		livro_4.set_nome("Top 10 Guerras para se morrer!");
		c.set(2002, 6, 6);
		livro_4.set_dataPublicacao(c.getTime());
		livro_4.set_autor(a2);
		livro_4.set_editora(e2);
		livros.add(livro_4);
	
		Livro livro_5 = new Livro();
		livro_5.set_nome("Sambando no Rock Sertanejo");
		c.set(2010, 2, 1);
		livro_5.set_dataPublicacao(c.getTime());
		livro_5.set_autor(a3);
		livro_5.set_editora(e1);
		livros.add(livro_5);
		
		
		
		Leitor leitorA = new Leitor("João", "Pereira", "51 96666 6666");
		Leitor leitorB = new Leitor("Joaquina", "Rocha", "51 98871 9876");
		leitorA.setLivrosPegos(livros.subList(1, 3));
		leitorB.setLivrosPegos(livros.subList(0, 4))
		;
		em.getTransaction().begin();
		//em.persist(a1);
		//em.persist(e2);
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
