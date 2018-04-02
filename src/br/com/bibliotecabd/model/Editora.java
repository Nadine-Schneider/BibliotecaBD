package br.com.bibliotecabd.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Editora implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_EDITORA")
	@SequenceGenerator(name="SEQ_EDITORA", sequenceName="s_Editora", allocationSize=1)
	@Column(name="ID_EDITORA")
	private long _id;
	
	@Column(name="Nome", length=60, nullable=false)
	private String _nome;
	
	public Editora() {}
	public Editora(String nome)
	{
		this.set_nome(nome);
	}
	
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
	
}
