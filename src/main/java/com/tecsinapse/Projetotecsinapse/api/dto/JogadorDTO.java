package com.tecsinapse.Projetotecsinapse.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JogadorDTO {
	
	private String nome;
	private String email;
	private String senha;
	
}
