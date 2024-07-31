package com.f_rafael_alvarez.Personajes_de_ficcion.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {
	
	@GetMapping("/saludo")
	public String Saludar() {
		return "Hola Usuario";
	}

}
