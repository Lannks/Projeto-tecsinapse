package com.tecsinapse.Projetotecsinapse.api.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tecsinapse.Projetotecsinapse.api.dto.JogadorDTO;
import com.tecsinapse.Projetotecsinapse.exception.ErroAutenticacao;
import com.tecsinapse.Projetotecsinapse.model.entity.Jogador;
import com.tecsinapse.Projetotecsinapse.model.entity.Quadras;
import com.tecsinapse.Projetotecsinapse.service.JogadorService;
import com.tecsinapse.Projetotecsinapse.service.QuadraService;

@RestController
@RequestMapping
public class QuadraResource {

	private QuadraService service;
	
	public QuadraResource(QuadraService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity salvar( @RequestBody JogadorDTO dto) {
		Quadras quadra = Quadras.builder()
				.nome(dto.getNome())	
				.build();
		
		try {
			Quadras quadrasalva = service.salvarQuadra(quadra);
			return new ResponseEntity(quadrasalva, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
