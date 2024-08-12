package com.f_rafael_alvarez.Personajes_de_ficcion.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.f_rafael_alvarez.Personajes_de_ficcion.dtos.ListaUsuariosDto;
import com.f_rafael_alvarez.Personajes_de_ficcion.entidades.Obra;
import com.f_rafael_alvarez.Personajes_de_ficcion.servicios.ObraServicio;
import com.f_rafael_alvarez.Personajes_de_ficcion.servicios.UsuarioServicio;

@RestController
@RequestMapping("/admin")
public class AdministradorControlador {
	
	@Autowired
	private ObraServicio obraServicio;
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@PostMapping("/obra")
	public void guardarObra(@RequestBody Obra obra) {
		obraServicio.guardarUna(obra);
	}
	
	@GetMapping("/usuarios")
	public List<ListaUsuariosDto> listarUsuariosPorNombre(@RequestParam String cadena){
		return usuarioServicio.devolverTodosPorNombre(cadena);
	}

}
