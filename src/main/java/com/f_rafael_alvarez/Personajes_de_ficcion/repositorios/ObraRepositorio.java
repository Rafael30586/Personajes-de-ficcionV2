package com.f_rafael_alvarez.Personajes_de_ficcion.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.f_rafael_alvarez.Personajes_de_ficcion.entidades.Obra;

@Repository
public interface ObraRepositorio extends JpaRepository<Obra,Long>{

}
