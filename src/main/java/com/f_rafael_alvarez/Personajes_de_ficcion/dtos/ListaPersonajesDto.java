package com.f_rafael_alvarez.Personajes_de_ficcion.dtos;

import java.time.LocalDate;

public record ListaPersonajesDto(Long id, String nombre, String apodo, 
		String tituloObra, LocalDate fechaObra, String usuario) {

}
