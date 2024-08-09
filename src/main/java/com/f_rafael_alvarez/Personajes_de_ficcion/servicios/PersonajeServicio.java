package com.f_rafael_alvarez.Personajes_de_ficcion.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f_rafael_alvarez.Personajes_de_ficcion.dtos.ListaPersonajesDto;
import com.f_rafael_alvarez.Personajes_de_ficcion.entidades.Personaje;
import com.f_rafael_alvarez.Personajes_de_ficcion.repositorios.PersonajeRepositorio;

@Service
public class PersonajeServicio {
	
	@Autowired
	private PersonajeRepositorio personajeRepositorio; 
	
	public List<Personaje> devolverTodos() {
		List<Personaje> personajes = personajeRepositorio.findAll();
		
		return personajes;
	}
	
	public Optional<Personaje> devolverPorId(Long id) {
		return personajeRepositorio.findById(id);
	}
	
	public void guardarPotId(Personaje personaje) {
		personajeRepositorio.save(personaje);
	}
	/*
	public List<ListaPersonajesDto> devolverTodosPorTitulo(String cadena){
		List<Personaje> personajes = personajeRepositorio.encontrarTodosPorTitulo(cadena);
		List<ListaPersonajesDto> personajesParaLista = new ArrayList<>();
		ListaPersonajesDto unPersonajeParaLista;
		
		for(Personaje p : personajes) {
			unPersonajeParaLista = new ListaPersonajesDto(p.getId(), p.getNombre(), 
					p.getApodo(), p.getObra().getTitulo(), 
					p.getObra().getFechaLanzamiento().getYear(),
					p.getUsuario());
			personajesParaLista.add(unPersonajeParaLista);
		}
		
		return personajesParaLista;
	}*/
	
	public List<ListaPersonajesDto> devolverTodosPorTitulo2(String cadena){
		return personajeRepositorio.encontrarTodosPorTitulo2(cadena);
	}

}
