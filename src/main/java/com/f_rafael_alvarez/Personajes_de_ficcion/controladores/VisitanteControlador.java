package com.f_rafael_alvarez.Personajes_de_ficcion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.f_rafael_alvarez.Personajes_de_ficcion.entidades.Usuario;
import com.f_rafael_alvarez.Personajes_de_ficcion.enums.Role;
import com.f_rafael_alvarez.Personajes_de_ficcion.servicios.UsuarioServicio;

@RestController
@RequestMapping("/")
public class VisitanteControlador {
	
	@Autowired
	private UsuarioServicio usuarioServicio; 
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	@PostMapping("/registro") //Primer usuario de prueba: rafael, 1234, fraq86@gmail.com, USER
	public void guardarUsuario(@RequestParam String username,
			@RequestParam String password, 
			@RequestParam String email) {
		Usuario usuario = new Usuario();
		usuario.setUsername(username);
		usuario.setPassword(passwordEncoder.encode(password));
		usuario.setEmail(email);
		usuario.setRoles(Role.USER);
		usuarioServicio.guardarUsuario(usuario);
	}

}
