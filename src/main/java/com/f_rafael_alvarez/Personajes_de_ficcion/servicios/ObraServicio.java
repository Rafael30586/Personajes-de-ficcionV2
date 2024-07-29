package com.f_rafael_alvarez.Personajes_de_ficcion.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f_rafael_alvarez.Personajes_de_ficcion.entidades.Obra;
import com.f_rafael_alvarez.Personajes_de_ficcion.repositorios.ObraRepositorio;

@Service
public class ObraServicio {
	
	@Autowired
	private ObraRepositorio obraRepositorio;
	
	public List<Obra> devolverTodas(){
		List<Obra> obras = obraRepositorio.findAll();
		
		return obras;
	}
	
	public Optional<Obra> devolverPorId(Long id){
		return obraRepositorio.findById(id);
	}

}
