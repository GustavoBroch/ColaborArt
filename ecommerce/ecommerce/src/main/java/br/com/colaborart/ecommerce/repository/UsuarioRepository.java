package br.com.colaborart.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.colaborart.ecommerce.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
