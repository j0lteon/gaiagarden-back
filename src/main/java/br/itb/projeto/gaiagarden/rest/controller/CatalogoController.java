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

import br.itb.projeto.gaiagarden.model.entity.Catalogo;
import br.itb.projeto.gaiagarden.service.CatalogoService;

@RestController
@RequestMapping("/catalogo/")
public class CatalogoController {

	private CatalogoService catalogoService;

	public CatalogoController(CatalogoService catalogoService) {
		super();
		this.catalogoService = catalogoService;
	}
	
	@GetMapping("findAll")
	public ResponseEntity<List<Catalogo>> findAll(){
		List<Catalogo> catalogos = catalogoService.findAll();
		
		return new ResponseEntity<List<Catalogo>> 
			(catalogos, HttpStatus.OK);
	}
	
	@PostMapping("create")
	public ResponseEntity<Catalogo> create (
			@RequestBody Catalogo catalogo){
		Catalogo _catalogo = catalogoService.create(catalogo);
		
		return new ResponseEntity<Catalogo>
		(_catalogo, HttpStatus.OK);
	}
	
	
	@PutMapping("inativar/{id}")
	public ResponseEntity<Catalogo> inativar(
			@PathVariable long id){
		
		Catalogo _catalogo = catalogoService.inativar(id);
		
		return new ResponseEntity<Catalogo>
								(_catalogo, HttpStatus.OK);
	}
	
	@PutMapping("reativar/{id}")
	public ResponseEntity<Catalogo> reativar(
			@PathVariable long id){
		
		Catalogo _catalogo = catalogoService.reativar(id);
		
		return new ResponseEntity<Catalogo>
	      						(_catalogo, HttpStatus.OK);
	}
}
