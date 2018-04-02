package br.com.bibliotecabd.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Autor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_AUTOR")
	@SequenceGenerator(name="SEQ_AUTOR", sequenceName="s_Autor", allocationSize=1)
	@Column(name="ID_AUTOR")
	private long _id;

	@Column(name="Nome",nullable = false, length = 60)
	private String _nome;
	
	@Column(name="Sobrenome",nullable = false, length = 60)
	private String _sobrenome;

	
	public Autor() {}
	
	public Autor(String nome, String sobrenome)
	{
		this.set_nome(nome);
		this.set_sobrenome(sobrenome);
	}
	
	public String get_nome() {
		return _nome;
	}

	public void set_nome(String _nome) {
		this._nome = _nome;
	}

	public String get_sobrenome() {
		return _sobrenome;
	}

	public void set_sobrenome(String _sobrenome) {
		this._sobrenome = _sobrenome;
	}
	
	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}

	
	
}
