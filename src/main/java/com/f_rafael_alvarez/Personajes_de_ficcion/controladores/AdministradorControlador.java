package com.f_rafael_alvarez.Personajes_de_ficcion.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.f_rafael_alvarez.Personajes_de_ficcion.dtos.ListaUsuariosDto;
import com.f_rafael_alvarez.Personajes_de_ficcion.entidades.Obra;
import com.f_rafael_alvarez.Personajes_de_ficcion.entidades.Personaje;
import com.f_rafael_alvarez.Personajes_de_ficcion.servicios.ObraServicio;
import com.f_rafael_alvarez.Personajes_de_ficcion.servicios.PersonajeServicio;
import com.f_rafael_alvarez.Personajes_de_ficcion.servicios.UsuarioServicio;

@RestController
@RequestMapping("/admin")
public class AdministradorControlador {
	
	@Autowired
	private ObraServicio obraServicio;
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@Autowired
	private PersonajeServicio personajeServicio;
	
	@PostMapping("/obra")
	public void guardarObra(@RequestBody Obra obra) {
		obraServicio.guardarUna(obra);
	}
	
	@GetMapping("/usuarios")
	public List<ListaUsuariosDto> listarUsuariosPorNombre(@RequestParam String cadena){
		return usuarioServicio.devolverTodosPorNombre(cadena);
	}
	
	@PutMapping("/personaje/{id}")
	public String editarPersonaje(@RequestBody Personaje personaje,@PathVariable Long id) {
		Personaje personajeParaEditar = personajeServicio.devolverPorId(id).get();
		
		if(personaje.getNombre() != null) {
			personajeParaEditar.setNombre(personaje.getNombre());
		}
		
		if(personaje.getApodo() != null) {
			personajeParaEditar.setApodo(personaje.getApodo());
		}
		
		if(personaje.getFotoUrl() != null) {
			personajeParaEditar.setFotoUrl(personaje.getFotoUrl());
		}
		
		personajeServicio.guardar(personajeParaEditar);
		
		return "Personaje editado con exito";
	}
	
	@PutMapping("/personaje/{id}/edicion")
	public String editarObraDePersonaje(@PathVariable Long id, @RequestParam Long idObra) {
		Obra obra = obraServicio.devolverPorId(idObra).get();
		Personaje personaje = personajeServicio.devolverPorId(id).get();
		
		personaje.setObra(obra);
		
		personajeServicio.guardar(personaje);
		
		return "Obra del personaje editada con exito";
	}

}
