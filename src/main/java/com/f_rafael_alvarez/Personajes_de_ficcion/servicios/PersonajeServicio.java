package com.f_rafael_alvarez.Personajes_de_ficcion.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f_rafael_alvarez.Personajes_de_ficcion.repositorios.PersonajeRepositorio;

@Service
public class PersonajeServicio {
	
	@Autowired
	private PersonajeRepositorio personajeRepositorio; 

}
