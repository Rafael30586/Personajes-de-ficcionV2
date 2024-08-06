package com.f_rafael_alvarez.Personajes_de_ficcion.controladores;


import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.f_rafael_alvarez.Personajes_de_ficcion.entidades.Obra;
import com.f_rafael_alvarez.Personajes_de_ficcion.entidades.Personaje;
import com.f_rafael_alvarez.Personajes_de_ficcion.servicios.ObraServicio;
import com.f_rafael_alvarez.Personajes_de_ficcion.servicios.PersonajeServicio;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {
	
	@Autowired
	private ObraServicio obraServicio;
	@Autowired
	private PersonajeServicio personajeSevicio;
	
	@GetMapping("/saludo")
	public String Saludar(HttpServletRequest request) {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		
		String username = securityContext.getAuthentication().getName();
		return "Hola "+username+". Número de sesión = "+request.getSession().getId();
	}
	
	@GetMapping("/obras")
	public List<Obra> listarObras(){
		return obraServicio.devolverTodas();
	}
	
	@PostMapping("/personaje/{id}")
	public void guardarPersonaje(@PathVariable Long id, @RequestBody Personaje personaje) {
		Obra obra = obraServicio.devolverPorId(id).get();
		personaje.setObra(obra);
		personajeSevicio.guardarPotId(personaje);
	}
	
	@GetMapping("/personajes")
	public List<Personaje> listarPersonajes(){
		return personajeSevicio.devolverTodos();
	}
}
