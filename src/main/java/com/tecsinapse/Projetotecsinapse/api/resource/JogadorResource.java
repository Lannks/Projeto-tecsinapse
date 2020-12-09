package com.tecsinapse.Projetotecsinapse.api.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tecsinapse.Projetotecsinapse.api.dto.JogadorDTO;
import com.tecsinapse.Projetotecsinapse.exception.ErroAutenticacao;
import com.tecsinapse.Projetotecsinapse.model.entity.Jogador;
import com.tecsinapse.Projetotecsinapse.service.JogadorService;

import lombok.Builder;

@RestController
@RequestMapping("/api/jogador")
public class JogadorResource {

	private JogadorService service;
	
	public JogadorResource(JogadorService service) {
		this.service = service;
	}
	
	@PostMapping("/autenticar")
	public ResponseEntity autenticar(@RequestBody JogadorDTO dto) {
		try {
			Jogador jogadorAutenticado = service.autenticar(dto.getEmail(), dto.getSenha());
			return ResponseEntity.ok(jogadorAutenticado);
		} catch (ErroAutenticacao e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity salvar( @RequestBody JogadorDTO dto) {
		Jogador jogador = Jogador.builder()
				.nome(dto.getNome())
				.email(dto.getEmail())
				.senha(dto.getSenha()).build();
		
		try {
			Jogador jogadorSalvo = service.salvarJogador(jogador);
			return new ResponseEntity(jogadorSalvo, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
