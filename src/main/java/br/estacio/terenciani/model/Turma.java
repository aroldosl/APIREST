package br.estacio.terenciani.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Turma {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@JsonFormat(pattern="", locale="pt-BR", timezone="")
	private Date inicio;
	@JsonFormat(pattern="", locale="pt-BR", timezone="")
	private Date termino;
	private byte totalVagas;
	private byte versao;
	@OneToMany(mappedBy="turma", cascade=CascadeType.ALL)
	@JsonIgnore
	private Collection<Matricula> matriculas;
	private boolean aberta;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getTermino() {
		return termino;
	}
	public void setTermino(Date termino) {
		this.termino = termino;
	}
	public byte getTotalVagas() {
		return totalVagas;
	}
	public void setTotalVagas(byte totalVagas) {
		this.totalVagas = totalVagas;
	}
	public byte getVersao() {
		return versao;
	}
	public void setVersao(byte versao) {
		this.versao = versao;
	}
	public Collection<Matricula> getMatriculas() {
		return matriculas;
	}
	public void setMatriculas(Collection<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	public boolean isAberta() {
		return aberta;
	}
	public void setAberta(boolean aberta) {
		this.aberta = aberta;
	}
}
