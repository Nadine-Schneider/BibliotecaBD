package br.com.bibliotecabd.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Livro implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_LIVRO")
	@SequenceGenerator(name="SEQ_LIVRO", sequenceName="s_livro", allocationSize=1)
	@Column(name="ID_LIVRO")
	private long _id;
	
	@Column(name="Nome", length = 80,  nullable = false) 
	private String _nome;
	
	@Column(name="Data_Publicacao", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date _dataPublicacao;
	
	@OneToOne(cascade=(CascadeType.ALL))
	@JoinColumn(name="ID_AUTOR")
	private Autor _autor;
	
	@OneToOne(cascade=(CascadeType.ALL))
	@JoinColumn(name="ID_EDITORA")
	private Editora _editora;
	
	
	
	
	
	public Livro() {}
	
	
	
	
	public String get_nome() {
		return _nome;
	}
	public void set_nome(String _nome) {
		this._nome = _nome;
	}
	public long get_id() {
		return _id;
	}
	public void set_id(long _id) {
		this._id = _id;
	}
	public Autor get_autor() {
		return _autor;
	}
	public void set_autor(Autor _autor) {
		this._autor = _autor;
	}
	public Date get_dataPublicacao() {
		return _dataPublicacao;
	}
	public void set_dataPublicacao(Date _dataPublicacao) {
		this._dataPublicacao = _dataPublicacao;
	}
	public Editora get_editora() {
		return _editora;
	}
	public void set_editora(Editora _editora) {
		this._editora = _editora;
	}

}
