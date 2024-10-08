package com.f_rafael_alvarez.Personajes_de_ficcion.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.f_rafael_alvarez.Personajes_de_ficcion.dtos.ListaPersonajesDto;
import com.f_rafael_alvarez.Personajes_de_ficcion.dtos.PersonajeConFotoDto;
import com.f_rafael_alvarez.Personajes_de_ficcion.entidades.Personaje;

@Repository
public interface PersonajeRepositorio extends JpaRepository<Personaje,Long>{
	/*
	@Query(value="SELECT p.id, p.nombre, p.apodo, p.obra.titulo, p.obra.fechaLanzamiento FROM Personaje p WHERE p.nombre LIKE %:cadena% ORDER BY p.nombre")
	public List<Personaje> encontrarTodosPorTitulo(@Param("cadena") String cadena);*/
	
	//Esta query no funciona 
	@Query("SELECT new com.f_rafael_alvarez.Personajes_de_ficcion.dtos.ListaPersonajesDto(p.id, p.nombre, p.apodo, p.obra.titulo, p.obra.fechaLanzamiento, p.usuario) FROM Personaje p WHERE p.nombre LIKE %:cadena% ORDER BY p.nombre")
	public List<ListaPersonajesDto> encontrarTodosPorTitulo2(@Param("cadena") String cadena);
	
	@Query("SELECT new com.f_rafael_alvarez.Personajes_de_ficcion.dtos.PersonajeConFotoDto(p.nombre, p.apodo, p.fotoUrl, p.obra.titulo) FROM Personaje p WHERE p.id=:id")
	public Optional<PersonajeConFotoDto> encontrarPersonajeParaMostrar(Long id);

}
