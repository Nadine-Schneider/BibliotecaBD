package br.com.bibliotecabd.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;


@Entity
public class Leitor implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_LEITOR")
	@SequenceGenerator(name="SEQ_LEITOR", sequenceName="s_leitor", allocationSize=1)
	@Column(name="ID_LEITOR")
	private long _id;
	
	@Column(name="Nome", nullable = false)
	private String _nome;
	@Column(name="Sobrenome", nullable = false)
	private String _sobrenome;
	@Column(name="Telefone", nullable = false)
	private String _telefone;
	
	@ManyToMany
	@JoinTable(name="LIVRO_LEITOR",
				joinColumns= {@JoinColumn(name="ID_LEITOR")},
				inverseJoinColumns= {@JoinColumn(name="ID_LIVRO")})
	private List<Livro> livrosPegos;
	
	public Leitor() {}
	public Leitor(String nome, String sobrenome, String telefone)
	{
		this._nome = nome;
		this._sobrenome = sobrenome;
		this._telefone = telefone;
	}
	
	
	public long get_id() {
		return _id;
	}
	public void set_id(long _id) {
		this._id = _id;
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
	public String get_telefone() {
		return _telefone;
	}
	public void set_telefone(String _telefone) {
		this._telefone = _telefone;
	}
	public List<Livro> getLivrosPegos() {
		return livrosPegos;
	}
	public void setLivrosPegos(List<Livro> livrosPegos) {
		this.livrosPegos = livrosPegos;
	}

}
