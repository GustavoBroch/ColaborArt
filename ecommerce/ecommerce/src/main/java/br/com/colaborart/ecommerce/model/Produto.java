package br.com.colaborart.ecommerce.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produto")
public class Produto {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long idProduto;
		
		@NotBlank
		@Size(min = 3, max = 140)
		private String descricaoProduto;
		
		@NotBlank
		@Size(min = 1, max = 5) 
		private String tamanho;
		
		@NotNull
		@Min(0)
		private BigDecimal valor;
		
		@NotNull
		private boolean disponivel;
		
		@NotNull
		@Min(0)
		private int estoque;
		
		@URL
		private String urlProduto;
		
		@ManyToOne
		@JsonIgnoreProperties("produto")
		private Categoria categoria;
		
		@ManyToOne
		@JsonIgnoreProperties("produto")
		private Usuario usuario;
		
		@NotBlank
		@Size(min =3, max = 70)
		private String nome;

		
		public long getIdProduto() {
			return idProduto;
		}

		public void setIdProduto(long idProduto) {
			this.idProduto = idProduto;
		}

		public String getDescricaoProduto() {
			return descricaoProduto;
		}

		public void setDescricaoProduto(String descricaoProduto) {
			this.descricaoProduto = descricaoProduto;
		}

		public String getTamanho() {
			return tamanho;
		}

		public void setTamanho(String tamanho) {
			this.tamanho = tamanho;
		}

		public BigDecimal getValor() {
			return valor;
		}

		public void setValor(BigDecimal valor) {
			this.valor = valor;
		}

		public boolean isDisponivel() {
			return disponivel;
		}

		public void setDisponivel(boolean disponivel) {
			this.disponivel = disponivel;
		}

		public int getEstoque() {
			return estoque;
		}

		public void setEstoque(int estoque) {
			this.estoque = estoque;
		}

		public String getUrlProduto() {
			return urlProduto;
		}

		public void setUrlProduto(String urlProduto) {
			this.urlProduto = urlProduto;
		}

		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}
		
		
}
