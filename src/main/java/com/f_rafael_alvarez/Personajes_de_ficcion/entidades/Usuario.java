package com.f_rafael_alvarez.Personajes_de_ficcion.entidades;

import com.f_rafael_alvarez.Personajes_de_ficcion.enums.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Usuario {// Agregar campo fecha y hora de registro, podria ser un LocalDateTime
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role roles;
    private String email;
    
	public Usuario() {
	}

	public Usuario(Long id, String username, String password, Role roles, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Role getRoles() {
		return roles;
	}

	public String getEmail() {
		return email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setRoles(Role roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", password=" + password + ", roles=" + roles
				+ ", email=" + email + "]";
	}
    
}
