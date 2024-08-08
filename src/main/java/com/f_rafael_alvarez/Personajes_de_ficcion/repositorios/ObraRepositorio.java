package com.f_rafael_alvarez.Personajes_de_ficcion.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.f_rafael_alvarez.Personajes_de_ficcion.entidades.Obra;

@Repository
public interface ObraRepositorio extends JpaRepository<Obra,Long>{
	
	@Query(value="SELECT o FROM Obra o WHERE o.titulo LIKE %:cadena% ORDER BY o.titulo")
	public List<Obra> encontrarTodasPorCadena(@Param("cadena") String cadena);

}
