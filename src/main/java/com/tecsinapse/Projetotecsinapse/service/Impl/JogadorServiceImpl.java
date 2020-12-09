package com.tecsinapse.Projetotecsinapse.service.Impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.tecsinapse.Projetotecsinapse.exception.ErroAutenticacao;
import com.tecsinapse.Projetotecsinapse.exception.RegraNegocioException;
import com.tecsinapse.Projetotecsinapse.model.entity.Jogador;
import com.tecsinapse.Projetotecsinapse.model.repository.JogadorRepository;
import com.tecsinapse.Projetotecsinapse.service.JogadorService;

@Service
public class JogadorServiceImpl implements JogadorService{

	private JogadorRepository repository;
	
	public JogadorServiceImpl(JogadorRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Jogador autenticar(String email, String senha) {
		Optional<Jogador> jogador = repository.findByEmail(email);
		
		if(!jogador.isPresent()) {
			throw new ErroAutenticacao("Jogador não encontrado para o email informado.");
		}
		
		if(!jogador.get().getSenha().equals(senha)) {
			throw new ErroAutenticacao("Senha Invalida");
		}
		return jogador.get();
	}

	@Override
	@Transactional
	public Jogador salvarJogador(Jogador jogador) {
		validarEmail(jogador.getEmail());
		return repository.save(jogador);
	}

	@Override
	public void validarEmail(String email) {
		boolean existe = repository.existsByEmail(email);
		if (existe) {
			throw new RegraNegocioException("Já existe um jogador cadastrado com esse email");
		}
	}

}
