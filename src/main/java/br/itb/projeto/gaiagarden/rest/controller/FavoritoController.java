package br.itb.projeto.gaiagarden.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itb.projeto.gaiagarden.model.entity.Favorito;
import br.itb.projeto.gaiagarden.service.FavoritoService;

@RestController
@RequestMapping("/favorito/")
public class FavoritoController {

	private FavoritoService favoritoService;

	public FavoritoController(FavoritoService favoritoService) {
		super();
		this.favoritoService = favoritoService;
	}
	
	@GetMapping("findAll")
	public ResponseEntity<List<Favorito>> findAll(){
		List<Favorito> favoritos = favoritoService.findAll();
		
		return new ResponseEntity<List<Favorito>> 
			(favoritos, HttpStatus.OK);
	}
	
	@PostMapping("create")
	public ResponseEntity<Favorito> create (
			@RequestBody Favorito favorito){
		Favorito _favorito = favoritoService.create(favorito);
		
		return new ResponseEntity<Favorito>
		(_favorito, HttpStatus.OK);
	}
	
	@PutMapping("inativar/{id}")
	public ResponseEntity<Favorito> inativar(
			@PathVariable long id){
		
		Favorito _favorito = favoritoService.inativar(id);
		
		return new ResponseEntity<Favorito>
								(_favorito, HttpStatus.OK);
	}
	
	@PutMapping("reativar/{id}")
	public ResponseEntity<Favorito> reativar(
			@PathVariable long id){
		
		Favorito _favorito = favoritoService.reativar(id);
		
		return new ResponseEntity<Favorito>
	      						(_favorito, HttpStatus.OK);
	}
}
