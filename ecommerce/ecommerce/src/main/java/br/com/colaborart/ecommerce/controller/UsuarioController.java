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

import br.com.colaborart.ecommerce.model.Usuario;
import br.com.colaborart.ecommerce.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repositorio;

	@GetMapping()
	public ResponseEntity<List<Usuario>> buscarTodosUsuarios() {
		return ResponseEntity.ok(repositorio.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable long id) {
		return repositorio.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping()
	public ResponseEntity<Usuario> inserirUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repositorio.save(usuario));
	}

	@PutMapping()
	public ResponseEntity<Usuario> atualizarUsuario(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.OK).body(repositorio.save(usuario));
	}

	@DeleteMapping("/{id}")
	public void deleteUsuario(@PathVariable long id) {
		repositorio.deleteById(id);
	}
}
