package com.f_rafael_alvarez.Personajes_de_ficcion.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "personajes")
public class Personaje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String apodo;
	@ManyToOne
	private Obra obra;
	@Column(name = "foto")
	private String fotoUrl;
	private String usuario;
	
	public Personaje() {
	}

	public Personaje(Long id, String nombre, String apodo, Obra obra, String fotoUrl, String usuario) {
		this.id = id;
		this.nombre = nombre;
		this.apodo = apodo;
		this.obra = obra;
		this.fotoUrl = fotoUrl;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApodo() {
		return apodo;
	}

	public Obra getObra() {
		return obra;
	}

	public String getFotoUrl() {
		return fotoUrl;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Personaje [id=" + id + ", nombre=" + nombre + ", apodo=" + apodo + ", obra=" + obra + ", fotoUrl="
				+ fotoUrl + ", usuario=" + usuario + "]";
	}

}
