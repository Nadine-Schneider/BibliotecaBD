package br.com.bibliotecabd.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "Emprestimo")

@Entity
public class Emprestimo implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_EMPRESTIMO")
	@SequenceGenerator(name="SEQ_EMPRESTIMO", sequenceName="s_emprestimo", allocationSize=1)
	@Column(name="ID_EMPRESTIMO")
	private long _id;


	@Temporal(TemporalType.DATE)
	@Column(name="Data_Empréstimo", nullable = false)
	private Date _dataEmprestimo;
	
	@ManyToOne
	private Livro _livroEmprestado;
	
	
	public Livro get_livroEmprestado() {
		return _livroEmprestado;
	}


	public void set_livroEmprestado(Livro _livroEmprestado) {
		this._livroEmprestado = _livroEmprestado;
	}


	public Emprestimo() {}
	
	public Emprestimo(Livro livro, Date data)
	{
		this.set_livroEmprestado(livro);
		this.set_dataEmprestimo(data);
	}
	
	
	public long get_id() {
		return _id;
	}



	public void set_id(long _id) {
		this._id = _id;
	}



	public Date get_dataEmprestimo() {
		return _dataEmprestimo;
	}



	public void set_dataEmprestimo(Date _dataEmprestimo) {
		this._dataEmprestimo = _dataEmprestimo;
	}
	

}
