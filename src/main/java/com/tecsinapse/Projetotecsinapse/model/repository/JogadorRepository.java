package com.tecsinapse.Projetotecsinapse.model.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecsinapse.Projetotecsinapse.model.entity.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Long>{

	boolean existsByEmail(String email);
	
	Optional<Jogador> findByEmail(String email);
}
