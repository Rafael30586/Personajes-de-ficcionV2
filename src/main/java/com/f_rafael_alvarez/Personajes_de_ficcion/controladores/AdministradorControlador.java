package com.f_rafael_alvarez.Personajes_de_ficcion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.f_rafael_alvarez.Personajes_de_ficcion.entidades.Obra;
import com.f_rafael_alvarez.Personajes_de_ficcion.servicios.ObraServicio;

@RestController
@RequestMapping("/admin")
public class AdministradorControlador {
	
	@Autowired
	private ObraServicio obraServicio;
	
	@PostMapping("/obra")
	public void guardarObra(@RequestBody Obra obra) {
		obraServicio.guardarUna(obra);
	}

}
