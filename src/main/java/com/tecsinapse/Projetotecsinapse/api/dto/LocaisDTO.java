package com.tecsinapse.Projetotecsinapse.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocaisDTO {

	private String nome;
	private String cidade;
	private String bairro;
	
}
