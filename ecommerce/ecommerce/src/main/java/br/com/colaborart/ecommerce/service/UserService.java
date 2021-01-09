package br.com.colaborart.ecommerce.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.colaborart.ecommerce.model.Usuario;
import br.com.colaborart.ecommerce.model.UsuarioLogin;
import br.com.colaborart.ecommerce.repository.UsuarioRepository;

@Service
public class UserService {

	@Autowired
	private UsuarioRepository userRepository;

	public Usuario CadastrarUsuario(Usuario usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		Optional<Usuario> usuarioPresente = userRepository.findByEmail(usuario.getEmail());
		
		if (usuarioPresente.isPresent()) {
			return null;
		}
		else if(usuario.getSenha().length() < 6) {
			return null;
		}
		else {
			String senhaEncoder = encoder.encode(usuario.getSenha());
			usuario.setSenha(senhaEncoder);
			return userRepository.save(usuario);
		}
	}

	public Optional<UsuarioLogin> Logar(Optional<UsuarioLogin> user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = userRepository.findByEmail(user.get().getEmail());
		if (usuario.isPresent()) {
			if (encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {
				String auth = user.get().getEmail() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);

				user.get().setToken(authHeader);
				user.get().setEmail(usuario.get().getEmail());
				user.get().setNomeCompleto(usuario.get().getNomeCompleto());
				return user;
			}
		}
		return null;
	}
}
