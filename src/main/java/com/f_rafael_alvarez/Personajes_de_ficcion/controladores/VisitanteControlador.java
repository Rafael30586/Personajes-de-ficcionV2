package com.f_rafael_alvarez.Personajes_de_ficcion.controladores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.f_rafael_alvarez.Personajes_de_ficcion.entidades.Usuario;
import com.f_rafael_alvarez.Personajes_de_ficcion.enums.Role;
import com.f_rafael_alvarez.Personajes_de_ficcion.servicios.UsuarioServicio;

@RestController
@RequestMapping("/visitante")
public class VisitanteControlador {
	
	@Autowired
	private UsuarioServicio usuarioServicio; 
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	@GetMapping("/registro")
	public ModelAndView formularioDeRegistro() {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("registro_usuarios.html");	
		return modelAndView;
	}
	
	@PostMapping("/registro") //Primer usuario de prueba: rafael, 1234, fraq86@gmail.com, USER
	public String guardarUsuario(@RequestParam String username,//Marcos -> 6789
			@RequestParam String password, //Gisela -> 8888
			@RequestParam String email) {
		String regexPassowrd = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		Pattern pattern = Pattern.compile(regexPassowrd);
		Matcher matcher = pattern.matcher(email);
		
		if(matcher.matches()) {
			Usuario usuario = new Usuario();
			usuario.setUsername(username);
			usuario.setPassword(passwordEncoder.encode(password));
			usuario.setEmail(email);
			usuario.setRoles(Role.USER);
			usuarioServicio.guardarUsuario(usuario);
			
			return "Usuario registardo correctamente";
		}
		return "La dirección de correo electrónico no es correcta";
	}
	

}
