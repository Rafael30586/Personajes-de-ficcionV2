package com.f_rafael_alvarez.Personajes_de_ficcion.servicios;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.f_rafael_alvarez.Personajes_de_ficcion.entidades.Usuario;
import com.f_rafael_alvarez.Personajes_de_ficcion.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicio implements UserDetailsService{
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	public void guardarUsuario(Usuario usuario) {
		usuarioRepositorio.save(usuario);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepositorio.findByUsername(username).get();
		DetallesDeUsuario detallesDeUsuario = new DetallesDeUsuario(usuario);
		
		// TODO Auto-generated method stub
		return detallesDeUsuario;
	} 

}

class DetallesDeUsuario implements UserDetails{
	
	private Usuario usuario;
	
	public DetallesDeUsuario() {
	}
	
	public DetallesDeUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.usuario.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.usuario.getUsername();
	}
	
	@Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
	
}
