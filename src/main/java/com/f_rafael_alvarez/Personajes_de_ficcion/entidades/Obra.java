package com.f_rafael_alvarez.Personajes_de_ficcion.entidades;

import java.time.LocalDate;

import com.f_rafael_alvarez.Personajes_de_ficcion.enums.ClasificacionObra;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "obras")
public class Obra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String titulo;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_de_lanzamiento")
	private LocalDate fechaLanzamiento;
	@Enumerated(EnumType.STRING)
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
