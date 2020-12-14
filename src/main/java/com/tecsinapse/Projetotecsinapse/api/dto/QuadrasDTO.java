package com.tecsinapse.Projetotecsinapse.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuadrasDTO {
	
	private Long id_quadra;
	private String nome;
	private Long id_local;
}
