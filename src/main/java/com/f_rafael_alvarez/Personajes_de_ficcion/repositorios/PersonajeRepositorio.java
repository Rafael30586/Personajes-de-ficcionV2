package com.f_rafael_alvarez.Personajes_de_ficcion.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.f_rafael_alvarez.Personajes_de_ficcion.entidades.Personaje;

@Repository
public interface PersonajeRepositorio extends JpaRepository<Personaje,Long>{
	
	@Query(value="SELECT p.id, p.nombre, p.apodo, p.obra.titulo, p.obra.fechaLanzamiento FROM Personaje p WHERE p.nombre LIKE %:cadena% ORDER BY p.nombre")
	public List<Personaje> encontrarTodosPorTitulo(@Param("cadena") String cadena);

}
