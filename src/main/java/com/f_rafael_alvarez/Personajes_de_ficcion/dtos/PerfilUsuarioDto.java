package com.f_rafael_alvarez.Personajes_de_ficcion.dtos;

import java.time.LocalDate;

public record PerfilUsuarioDto(String nombre, String email, LocalDate fechaRegistro, String fotoArchivo) {

}
