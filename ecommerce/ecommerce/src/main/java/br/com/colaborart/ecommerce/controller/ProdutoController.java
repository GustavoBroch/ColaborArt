package br.com.colaborart.ecommerce.controller;

import java.util.List;

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

import br.com.colaborart.ecommerce.model.Produto;
import br.com.colaborart.ecommerce.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin(value = "*",  allowedHeaders = "*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repositorio;
	
	@GetMapping()
	public ResponseEntity<List<Produto>> buscarTodosProdutos(){
		return ResponseEntity.ok(repositorio.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable long id){
		return repositorio.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/produto/{nome}")
	public ResponseEntity<List<Produto>> buscarProduto(@PathVariable String nome){
		return ResponseEntity.ok(repositorio.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping()
	public ResponseEntity<Produto> inserirProduto(@RequestBody Produto amostra){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositorio.save(amostra));
	}
	
	@PutMapping()
	public ResponseEntity<Produto> atualizarProduto(@RequestBody Produto amostra){
		return ResponseEntity.status(HttpStatus.OK).body(repositorio.save(amostra));
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable long id) {
		repositorio.deleteById(id);
	}

}
