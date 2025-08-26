package br.sp.senai.escola.model;

import java.time.LocalDate;

import br.sp.senai.escola.model.enumerador.EStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="turmas")
public class Turma {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String titulo;
	private LocalDate dtInicio;
	
	@Enumerated(EnumType.STRING)
	private EStatus status;
	
	public Turma() {}

	public Turma(Long id, String titulo, LocalDate dtInicio, EStatus status) {
		
		this.id = id;
		this.titulo = titulo;
		this.dtInicio = dtInicio;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(LocalDate dtInicio) {
		this.dtInicio = dtInicio;
	}

	public EStatus getStatus() {
		return status;
	}

	public void setStatus(EStatus status) {
		this.status = status;
	}
	
	
	

	}
