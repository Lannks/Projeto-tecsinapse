package com.tecsinapse.Projetotecsinapse.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "quadras", schema = "tecsinapse")
@Builder
@Data
public class Quadras {

	@Id
	@Column(name = "id_quadra")
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long id_quadra;
	
	@Column(name = "nome")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "id_local")
	private Locais locais;
	
	
}
