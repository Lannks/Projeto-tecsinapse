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
@Table(name = "jogador" , schema = "tecsinapse")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Jogador {

	@Id
	@Column(name = "id_jogador")
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id_jogador;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "senha")
	private String senha;

	
	
}
