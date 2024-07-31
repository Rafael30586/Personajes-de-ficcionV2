package com.f_rafael_alvarez.Personajes_de_ficcion.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class IngresoControlador {
	
	@GetMapping("/login")
	public ModelAndView formularioDeLogin() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("ingreso_usuarios.html");
		return modelAndView;
	}

}
