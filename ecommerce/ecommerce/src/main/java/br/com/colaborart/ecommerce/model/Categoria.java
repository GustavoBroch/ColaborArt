package br.com.colaborart.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

	
	// linha de numero de identificacao(idCategoria) dentro de uma categoria(ex bones , camisetas , calca , etc ) .  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCategoria;

	// linha de String para tipo de Produto -- adequado para organizacao do tipo de produto aprensentado na landing page.
	@NotBlank
	@Size(min = 3, max = 50) 
	private String tipoProduto;

	// String para descricao da categoria do produto - material de composicao , linha(estilo/colecao) .
	@NotBlank
	@Size(min = 5, max = 200)
	private String descricaoCategoria;

	
	 // getters & setters dos atributos do model.
	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}

}
