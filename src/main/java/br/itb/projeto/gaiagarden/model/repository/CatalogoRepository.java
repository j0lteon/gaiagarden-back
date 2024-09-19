package br.itb.projeto.gaiagarden.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.itb.projeto.gaiagarden.model.entity.Catalogo;

@Repository
public interface CatalogoRepository extends JpaRepository<Catalogo, Long>{
}
