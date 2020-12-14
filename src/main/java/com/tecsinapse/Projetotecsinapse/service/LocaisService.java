package com.tecsinapse.Projetotecsinapse.service;

import com.tecsinapse.Projetotecsinapse.model.entity.Locais;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

public interface LocaisService {

	Locais salvar(Locais locais);
	
	List<Locais> buscar(Locais locaisFiltro);
	
	void deletar(Locais locais);

	Optional<Locais> obterPorId(Long id);

	List<Locais> getAll();
}
