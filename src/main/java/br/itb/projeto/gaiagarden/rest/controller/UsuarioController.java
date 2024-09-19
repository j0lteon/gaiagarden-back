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

import br.itb.projeto.gaiagarden.model.entity.Usuario;
import br.itb.projeto.gaiagarden.service.UsuarioService;

@RestController
@RequestMapping("/usuario/")
public class UsuarioController {

	private UsuarioService usuarioService;
	// Source -> Generate Constructor using Fields...

	public UsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}

	@GetMapping("findAll")
	public ResponseEntity<List<Usuario>> findAll() {

		List<Usuario> usuarios = usuarioService.findAll();

		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}

	@GetMapping("findById/{id}")
	public ResponseEntity<Usuario> findByid(
		@PathVariable long id) {
		
		Usuario usuario =
				usuarioService.findByid(id);
		
		return new ResponseEntity<Usuario>
					(usuario, HttpStatus.OK);
	}
	
	@GetMapping("findByEmail/{email}")
	public ResponseEntity<Usuario> findByemail(
		@PathVariable String email) {
		
		Usuario usuario =
				usuarioService.findByemail(email);
		
		return new ResponseEntity<Usuario>
					(usuario, HttpStatus.OK);
	}
	
	@PostMapping("create")
	public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
		Usuario _usuario = usuarioService.create(usuario);
		
		return new ResponseEntity<Usuario>
		(_usuario, HttpStatus.OK);
	}
	
	@PostMapping("signin")
	public ResponseEntity<?> signin(@RequestBody Usuario usuarioParam){
		
		Usuario usuario =
				usuarioService.signin(usuarioParam.getEmail(), usuarioParam.getSenha());
		if(usuario != null) {
			return ResponseEntity.ok().body(usuario);
		}
		return ResponseEntity.badRequest()
				.body("Dados Incorretos!");
	}
	
	@PutMapping("inativar/{id}")
	public ResponseEntity<Usuario> inativar(
			@PathVariable long id){
		
		Usuario _usuario = usuarioService.inativar(id);
		
		return new ResponseEntity<Usuario>
								(_usuario, HttpStatus.OK);
	}
	
	@PutMapping("reativar/{id}")
	public ResponseEntity<Usuario> reativar(
			@PathVariable long id){
		
		Usuario _usuario = usuarioService.reativar(id);
		
		return new ResponseEntity<Usuario>
	      						(_usuario, HttpStatus.OK);
	}
	
	@PutMapping("alterarSenha/{id}")
	public ResponseEntity<Usuario> alterarSenha(
			@PathVariable long id,
			@RequestBody Usuario usuario){
		
		Usuario _usuario = 
				usuarioService.alterarSenha(id, usuario);
		
		return new ResponseEntity<Usuario>
								(_usuario, HttpStatus.OK);
	}
	
}
