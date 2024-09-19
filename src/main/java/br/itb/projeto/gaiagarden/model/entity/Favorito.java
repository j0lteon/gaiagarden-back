package br.itb.projeto.gaiagarden.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Favorito")
public class Favorito {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDateTime dataCadastro;
	@JoinColumn(name = "usuario_id")
	@ManyToOne
	private Usuario usuario;
	@JoinColumn(name = "produto_id")
	@ManyToOne
	private Produto produto;
	
	private String statusFavorito;

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getStatusFavorito() {
		return statusFavorito;
	}
	public void setStatusFavorito(String statusFavorito) {
		this.statusFavorito = statusFavorito;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
