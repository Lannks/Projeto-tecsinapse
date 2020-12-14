package com.tecsinapse.Projetotecsinapse.service;

import java.util.List;

import com.tecsinapse.Projetotecsinapse.model.entity.Quadras;

public interface QuadraService {

	Quadras salvarQuadra(Quadras locais);
	
	List<Quadras> buscar(Quadras locaisFiltro);
	
	void deletar(Quadras locais);
}
