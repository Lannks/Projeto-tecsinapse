package com.tecsinapse.Projetotecsinapse.service;

import com.tecsinapse.Projetotecsinapse.model.entity.Locais;

import java.util.List;

public interface LocaisService {

	Locais salvar(Locais locais);
	
	List<Locais> buscar(Locais locaisFiltro);
	
	void deletar(Locais locais);
}
