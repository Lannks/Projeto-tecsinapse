package com.tecsinapse.Projetotecsinapse.service;

import com.tecsinapse.Projetotecsinapse.model.entity.Jogador;

public interface JogadorService {

	Jogador autenticar(String email, String senha);
	
	Jogador salvarJogador(Jogador jogador);
	
	void validarEmail(String email);

}
