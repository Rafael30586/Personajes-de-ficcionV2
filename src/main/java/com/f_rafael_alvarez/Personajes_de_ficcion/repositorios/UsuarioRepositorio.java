package com.f_rafael_alvarez.Personajes_de_ficcion.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.f_rafael_alvarez.Personajes_de_ficcion.entidades.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long>{
	
	Optional<Usuario> findByUsername(String username);

}
