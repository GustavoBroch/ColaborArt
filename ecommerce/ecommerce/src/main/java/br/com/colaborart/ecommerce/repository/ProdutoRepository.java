package br.com.colaborart.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.colaborart.ecommerce.model.Categoria;
import br.com.colaborart.ecommerce.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	public Optional<Produto> findByNomeIgnoreCaseAndTamanhoIgnoreCase(String nome, String tamanho);
	
	public Optional <Produto> findByIdProduto(long id);
	
	public List<Produto> findAllByNomeContainingIgnoreCase(String nome);
	

		
	
}
