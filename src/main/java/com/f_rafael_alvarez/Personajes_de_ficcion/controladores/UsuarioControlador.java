package com.f_rafael_alvarez.Personajes_de_ficcion.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.f_rafael_alvarez.Personajes_de_ficcion.entidades.Obra;
import com.f_rafael_alvarez.Personajes_de_ficcion.servicios.ObraServicio;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {
	
	@Autowired
	private ObraServicio obraServicio;
	
	@GetMapping("/saludo")
	public String Saludar() {
		return "Hola Usuario";
	}
	
	@GetMapping("/obras")
	public List<Obra> listarObras(){
		return obraServicio.devolverTodas();
	}

}
