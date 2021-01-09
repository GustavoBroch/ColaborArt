package br.com.colaborart.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.colaborart.ecommerce.model.Categoria;
import br.com.colaborart.ecommerce.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repositorio;

	@GetMapping()
	public ResponseEntity<List<Categoria>> buscarTodasCategorias() {
		return ResponseEntity.ok(repositorio.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> buscarCategoriaPorId(@PathVariable long id) {
		return repositorio.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/produtos/{tipoProduto}")
	public ResponseEntity<List<Categoria>> buscarProdutoPorCategoria(@PathVariable String tipoProduto) {
		return ResponseEntity.ok(repositorio.findByTipoProdutoContainingIgnoreCase(tipoProduto));
	}

	@PostMapping()
	public ResponseEntity<Categoria> inserirCategoria(@RequestBody Categoria categoria) {

		Optional<Categoria> categoriaNome = repositorio.findByTipoProdutoIgnoreCase(categoria.getTipoProduto());

		if (categoriaNome.isEmpty()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(repositorio.save(categoria));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

	}

	@PutMapping()
	public ResponseEntity<Categoria> atualizarCategoria(@RequestBody Categoria categoria) {
		Optional<Categoria> categoriaId = repositorio.findById(categoria.getIdCategoria());

		if (categoriaId.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		Optional<Categoria> categoriaNome = repositorio.findByTipoProdutoIgnoreCase(categoria.getTipoProduto());

		if (categoriaNome.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(repositorio.save(categoria));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@DeleteMapping("/{id}")
	public void deleteCategoria(@PathVariable long id) {
		repositorio.deleteById(id);
	}

}
