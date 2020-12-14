package com.tecsinapse.Projetotecsinapse.service.Impl;

import java.util.List;


import java.util.Objects;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tecsinapse.Projetotecsinapse.model.entity.Quadras;
import com.tecsinapse.Projetotecsinapse.model.repository.QuadraRepository;
import com.tecsinapse.Projetotecsinapse.service.QuadraService;
@Service
public class QuadraServiceImpl implements QuadraService{

	private QuadraRepository repository;

	public QuadraServiceImpl(QuadraRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public Quadras salvarQuadra(Quadras quadras) {
		return repository.save(quadras);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Quadras> buscar(Quadras locaisFiltro) {
		Example example = Example.of(locaisFiltro,
				ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));
		return repository.findAll(example);
	}

	@Override
	@Transactional
	public void deletar(Quadras quadras) {
		Objects.requireNonNull(quadras.getId_quadra());
		repository.delete(quadras);
	}

}
