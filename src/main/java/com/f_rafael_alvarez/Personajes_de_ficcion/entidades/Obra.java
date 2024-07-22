package com.f_rafael_alvarez.Personajes_de_ficcion.entidades;

import java.time.LocalDate;

import com.f_rafael_alvarez.Personajes_de_ficcion.enums.ClasificacionObra;

public class Obra {
	
	private Long id;
	private String titulo;
	private LocalDate fechaLanzamiento;
	private ClasificacionObra clasificacion;
	
	public Obra() {
	}

	public Obra(Long id, String titulo, LocalDate fechaLanzamiento, ClasificacionObra clasificacion) {
		this.id = id;
		this.titulo = titulo;
		this.fechaLanzamiento = fechaLanzamiento;
		this.clasificacion = clasificacion;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public LocalDate getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public ClasificacionObra getClasificacion() {
		return clasificacion;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}

	public void setClasificacion(ClasificacionObra clasificacion) {
		this.clasificacion = clasificacion;
	}

	@Override
	public String toString() {
		return "Obra [id=" + id + ", titulo=" + titulo + ", fechaLanzamiento=" + fechaLanzamiento + ", clasificacion="
				+ clasificacion + "]";
	}
	
	
}
