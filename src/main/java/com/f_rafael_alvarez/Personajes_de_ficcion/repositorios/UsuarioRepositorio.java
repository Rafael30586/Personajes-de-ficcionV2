package com.f_rafael_alvarez.Personajes_de_ficcion.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.f_rafael_alvarez.Personajes_de_ficcion.dtos.ListaUsuariosDto;
import com.f_rafael_alvarez.Personajes_de_ficcion.entidades.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long>{
	
	Optional<Usuario> findByUsername(String username);
	
	@Query("SELECT new com.f_rafael_alvarez.Personajes_de_ficcion.dtos.ListaUsuariosDto(u.username, u.email) FROM Usuario u WHERE u.username LIKE %:cadena% ORDER BY u.username")
	List<ListaUsuariosDto> encontrarTodosPorNombre(@Param("cadena") String cadena);

}
