package com.f_rafael_alvarez.Personajes_de_ficcion.controladores;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.f_rafael_alvarez.Personajes_de_ficcion.dtos.ListaPersonajesDto;
import com.f_rafael_alvarez.Personajes_de_ficcion.dtos.PersonajeConFotoDto;
import com.f_rafael_alvarez.Personajes_de_ficcion.entidades.Obra;
import com.f_rafael_alvarez.Personajes_de_ficcion.entidades.Personaje;
import com.f_rafael_alvarez.Personajes_de_ficcion.entidades.Usuario;
import com.f_rafael_alvarez.Personajes_de_ficcion.enums.Role;
import com.f_rafael_alvarez.Personajes_de_ficcion.servicios.ObraServicio;
import com.f_rafael_alvarez.Personajes_de_ficcion.servicios.PersonajeServicio;
import com.f_rafael_alvarez.Personajes_de_ficcion.servicios.UsuarioServicio;

@RestController
@RequestMapping("/visitante")
public class VisitanteControlador {
	
	@Autowired
	private UsuarioServicio usuarioServicio; 
	@Autowired
	private PasswordEncoder passwordEncoder; 
	@Autowired
	private ObraServicio obraServicio;
	@Autowired
	private PersonajeServicio personajeServicio;
	
	@GetMapping("/registro")
	public ModelAndView formularioDeRegistro() {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("registro_usuarios.html");	
		return modelAndView;
	}
	
	@PostMapping("/registro") //Primer usuario de prueba: Rafael, 1234, fraq86@gmail.com, ADMIN
	public String guardarUsuario(@RequestParam String username,//Marcos -> 6789
			@RequestParam String password, //Gisela -> 8888
			@RequestParam String email) {
		String regexEmail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		Pattern pattern = Pattern.compile(regexEmail);
		Matcher matcher = pattern.matcher(email);
		
		String regexUsuario = "^[A-Za-z0-9_]{4,}$";
		Pattern pattern2 = Pattern.compile(regexUsuario);
		Matcher matcherUsername = pattern2.matcher(username);
		Matcher matcherPassword = pattern2.matcher(password);
		
		if(!matcherUsername.matches()||!matcherPassword.matches()) {
			return "Nombre de usuario o contraseña incorrecta. Solo se puede usar letras, números y guiones bajos";
		}
		
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
	
	@GetMapping("/obras")
	public List<Obra> listarObrasPorTitulo(@RequestParam String cadena){
		return obraServicio.devolverTodasPorTitulo(cadena);	
	}
	
	@GetMapping("/personajes")
	public List<ListaPersonajesDto> listarPersonajesPorTitulo2(@RequestParam String cadena){
		return personajeServicio.devolverTodosPorTitulo2(cadena);
	}
	
	@GetMapping("/personaje/{id}")
	public ModelAndView mostrarPersonajeConFoto(@PathVariable Long id, Model model) {
		PersonajeConFotoDto personaje = personajeServicio.devolverPersonajeParaMostrar(id);
		ModelAndView modelAndView = new ModelAndView();
		model.addAttribute("personaje", personaje);
		modelAndView.setViewName("personaje_individual.html");
		
		return modelAndView;
	}
	
}
