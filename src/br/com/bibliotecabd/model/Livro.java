package br.com.bibliotecabd.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.OneToOne;

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
	
	@Column(name="Título", length = 80,  nullable = false) 
	private String _titulo;
	
	@Column(name="Data_Publicacao", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date _dataPublicacao;
	
	@ManyToMany
	@JoinTable(name="LIVRO_AUTOR",
			joinColumns= {@JoinColumn(name="ID_LIVRO")},
			inverseJoinColumns= {@JoinColumn(name="ID_AUTOR")})
	private List<Autor> _autor;
	
	
	@Column(name="Editora", length = 80, nullable = false)
	private String _editora;
	
	public Livro() {}
	
	
	public String get_titulo() {
		return _titulo;
	}
	public void set_titulo(String _titulo) {
		this._titulo = _titulo;
	}
	public long get_id() {
		return _id;
	}
	public void set_id(long _id) {
		this._id = _id;
	}
	public List<Autor> get_autor() {
		return _autor;
	}
	public void set_autor(List<Autor> _autor) {
		this._autor = _autor;
	}
	public Date get_dataPublicacao() {
		return _dataPublicacao;
	}
	public void set_dataPublicacao(Date _dataPublicacao) {
		this._dataPublicacao = _dataPublicacao;
	}
	public String get_editora() {
		return _editora;
	}
	public void set_editora(String _editora) {
		this._editora = _editora;
	}

}
