package br.itb.projeto.gaiagarden.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.itb.projeto.gaiagarden.model.entity.Catalogo;
import br.itb.projeto.gaiagarden.model.repository.CatalogoRepository;
import jakarta.transaction.Transactional;

@Service
public class CatalogoService {

	private CatalogoRepository catalogoRepository;

	public CatalogoService(CatalogoRepository catalogoRepository) {
		super();
		this.catalogoRepository = catalogoRepository;
	}
	
	public List<Catalogo> findAll(){
		List<Catalogo> catalogos = catalogoRepository.findAll();
		return catalogos;
	}
	
	@Transactional
	public Catalogo create(Catalogo catalogo) {
		
		catalogo.setDataCadastro(LocalDateTime.now());
		catalogo.setStatusProdCat("ATIVO");
		
		return catalogoRepository.save(catalogo);
	}
	
	@Transactional
	public Catalogo update(long id) {
		Optional<Catalogo> _catalogo =
				catalogoRepository.findById(id);
		
		if (_catalogo.isPresent()) {
			Catalogo catalogoAtualizado = _catalogo.get();
			catalogoAtualizado.setStatusProdCat("ATIVO");
															   	
			return catalogoRepository.save(catalogoAtualizado);
		}
		return null;
	}
	
	@Transactional
	public Catalogo inativar(long id) {
		Optional<Catalogo> _catalogo =
				catalogoRepository.findById(id);
		
		if (_catalogo.isPresent()) {
			Catalogo catalogoAtualizada = _catalogo.get();
			catalogoAtualizada.setStatusProdCat("INATIVO");
			
			return catalogoRepository.save(catalogoAtualizada);
		}
		return null;
	}
	
	@Transactional
	public Catalogo reativar(long id) {

		Optional<Catalogo> _catalogo = catalogoRepository.findById(id);

		if (_catalogo.isPresent()) {
			Catalogo catalogoAtualizado = _catalogo.get();

			catalogoAtualizado.setStatusProdCat("ATIVO");
			
			return catalogoRepository.save(catalogoAtualizado);
		}
		return null;
	}
}
