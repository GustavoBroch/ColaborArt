package br.com.colaborart.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.colaborart.ecommerce.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	public Optional<Categoria> findByTipoProdutoIgnoreCase(String tipoProduto);
	
	public Optional <Categoria> findByIdCategoria(long id);
	
	public List<Categoria> findByTipoProdutoContainingIgnoreCase(String tipoProduto);
}
