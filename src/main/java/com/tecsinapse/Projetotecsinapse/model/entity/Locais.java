package com.tecsinapse.Projetotecsinapse.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "locais", schema = "tecsinapse")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Locais {

	@Id
	@Column(name = "id_local")
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cidade")
	private String cidade;
	
	@Column(name = "bairro")
	private String bairro;

	
	
}
