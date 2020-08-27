package com.santandertech.form.webapp.models.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

public class Usuario {

	@NotEmpty
	@Getter
	@Setter
	@Size(min = 3, max = 10) // Size sólo funciona para campos String
	private String username;
	@NotEmpty
	@Getter
	@Setter
	private String password;
	@NotEmpty
	@Getter
	@Setter
	@Email(message = "correo incorrecto name@dominio.com") // Solo para campos del tipo email o correo
	private String email;
	@NotEmpty(message = "El nombre no puede estar vacio")
	@Getter
	@Setter
	private String nombre;
	@NotEmpty
	@Getter
	@Setter
	private String apellido;
	@Getter
	@Setter
	private String identificador;

}
