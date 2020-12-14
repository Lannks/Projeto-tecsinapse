package com.tecsinapse.Projetotecsinapse.api.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tecsinapse.Projetotecsinapse.api.dto.LocaisDTO;
import com.tecsinapse.Projetotecsinapse.exception.RegraNegocioException;
import com.tecsinapse.Projetotecsinapse.model.entity.Locais;
import com.tecsinapse.Projetotecsinapse.service.LocaisService;

@RestController
@RequestMapping("/api/locais")
public class LocaisResource {

	private LocaisService service;

	public LocaisResource(LocaisService service) {
		this.service = service;
	}

	@GetMapping
	public List<Locais> getAll() {
		return service.getAll();
	}

	@PostMapping
	public ResponseEntity salvar(@RequestBody LocaisDTO dto) {
		try {
			Locais entidade = converter(dto);
			entidade = service.salvar(entidade);
			return ResponseEntity.ok(entidade);
		} catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity deletar(@PathVariable("id") Long id) {
		return service.obterPorId(id).map(entidade -> {
			service.deletar(entidade);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}).orElseGet(() -> new ResponseEntity("Local não encontrado na base de Dados.", HttpStatus.BAD_REQUEST));
	}

	private Locais converter(LocaisDTO dto) {
		Locais local = new Locais();
		local.setNome(dto.getNome());
		local.setCidade(dto.getCidade());
		local.setBairro(dto.getBairro());

		return local;
	}
}
