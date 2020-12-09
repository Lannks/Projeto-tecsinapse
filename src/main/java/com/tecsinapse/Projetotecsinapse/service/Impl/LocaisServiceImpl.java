package com.tecsinapse.Projetotecsinapse.service.Impl;

import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tecsinapse.Projetotecsinapse.model.entity.Locais;
import com.tecsinapse.Projetotecsinapse.model.repository.LocaisRepository;
import com.tecsinapse.Projetotecsinapse.service.LocaisService;

@Service
public class LocaisServiceImpl implements LocaisService {

	private LocaisRepository repository;

	public LocaisServiceImpl(LocaisRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public Locais salvar(Locais locais) {
		return repository.save(locais);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Locais> buscar(Locais locaisFiltro) {
		Example example = Example.of(locaisFiltro,
				ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));
		return repository.findAll(example);
	}

	@Override
	@Transactional
	public void deletar(Locais locais) {
		Objects.requireNonNull(locais.getId_local());
		repository.delete(locais);
	}

}
