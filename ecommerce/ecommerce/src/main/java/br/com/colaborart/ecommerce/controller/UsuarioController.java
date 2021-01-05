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

import br.com.colaborart.ecommerce.model.Usuario;
import br.com.colaborart.ecommerce.model.UsuarioLogin;
import br.com.colaborart.ecommerce.repository.UsuarioRepository;
import br.com.colaborart.ecommerce.service.UserService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UserService userService;

	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> Autentication(@RequestBody Optional<UsuarioLogin> usuario) {
		return userService.Logar(usuario).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario) {

		Usuario user = userService.CadastrarUsuario(usuario);

		if (user == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}

	/*
	 * @Autowired private UsuarioRepository repositorio;
	 * 
	 * @GetMapping() public ResponseEntity<List<Usuario>> buscarTodosUsuarios() {
	 * return ResponseEntity.ok(repositorio.findAll()); }
	 * 
	 * @GetMapping("/{id}") public ResponseEntity<Usuario>
	 * buscarUsuarioPorId(@PathVariable long id) { return
	 * repositorio.findById(id).map(resposta -> ResponseEntity.ok(resposta))
	 * .orElse(ResponseEntity.notFound().build()); }
	 * 
	 * @PostMapping() public ResponseEntity<Usuario> inserirUsuario(@RequestBody
	 * Usuario usuario) { return
	 * ResponseEntity.status(HttpStatus.CREATED).body(repositorio.save(usuario)); }
	 * 
	 * @PutMapping() public ResponseEntity<Usuario> atualizarUsuario(@RequestBody
	 * Usuario usuario){ return
	 * ResponseEntity.status(HttpStatus.OK).body(repositorio.save(usuario)); }
	 * 
	 * @DeleteMapping("/{id}") public void deleteUsuario(@PathVariable long id) {
	 * repositorio.deleteById(id); }
	 */

}
