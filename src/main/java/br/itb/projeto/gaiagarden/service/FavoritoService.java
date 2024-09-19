package br.itb.projeto.gaiagarden.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.itb.projeto.gaiagarden.model.entity.Favorito;
import br.itb.projeto.gaiagarden.model.repository.FavoritoRepository;
import jakarta.transaction.Transactional;

@Service
public class FavoritoService {
	
	private FavoritoRepository favoritoRepository;

	public FavoritoService(FavoritoRepository favoritoRepository) {
		super();
		this.favoritoRepository = favoritoRepository;
	}
	
	public List<Favorito> findAll() {
		List<Favorito> favoritos = favoritoRepository.findAll();
		return favoritos;
	}
	
	@Transactional
	public Favorito create(Favorito favorito) {
		
		favorito.setDataCadastro(LocalDateTime.now());
		favorito.setStatusFavorito("ATIVO");
		
		return favoritoRepository.save(favorito);
	}
	
	@Transactional
	public Favorito update(long id) {
		Optional<Favorito> _favorito =
				favoritoRepository.findById(id);
		
		if (_favorito.isPresent()) {
			Favorito favoritoAtualizada = _favorito.get();
			favoritoAtualizada.setStatusFavorito("ATIVO");
			
			return favoritoRepository.save(favoritoAtualizada);
		}
		return null;
	}
	
	@Transactional
	public Favorito inativar(long id) {
		Optional<Favorito> _favorito =
				favoritoRepository.findById(id);
		
		if (_favorito.isPresent()) {
			Favorito favoritoAtualizada = _favorito.get();
			favoritoAtualizada.setStatusFavorito("INATIVO");
			
			return favoritoRepository.save(favoritoAtualizada);
		}
		return null;
	}
	
	@Transactional
	public Favorito reativar(long id) {

		Optional<Favorito> _favorito = favoritoRepository.findById(id);

		if (_favorito.isPresent()) {
			Favorito favoritoAtualizado = _favorito.get();

			favoritoAtualizado.setStatusFavorito("ATIVO");
			
			return favoritoRepository.save(favoritoAtualizado);
		}
		return null;
	}
}
