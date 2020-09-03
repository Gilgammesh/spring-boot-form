package com.santandertech.form.webapp.models.domain;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
//import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

//import org.springframework.format.annotation.DateTimeFormat;

import com.santandertech.form.webapp.validation.IdentificadorRegexp;
import com.santandertech.form.webapp.validation.Requerido;

import lombok.Getter;
import lombok.Setter;

public class Usuario {

	@NotBlank	
	@Size(min = 3, max = 10) // Size sólo funciona para campos String
	@Getter @Setter private String username;
	
	@NotEmpty
	@Getter @Setter private String password;
	
	@NotEmpty
	@Email(message = "correo incorrecto name@dominio.com") // Solo para campos del tipo email o correo
	@Getter @Setter private String email;
	
	@NotEmpty(message = "El nombre no puede estar vacio")	
	@Getter @Setter private String nombre;
	
	//@NotEmpty
	@Requerido
	@Getter @Setter private String apellido;
	
	//@Pattern(regexp = "[A-Z]{3}[-][0-9]{4}")
	@IdentificadorRegexp
	@Getter @Setter private String identificador;
	
	@NotNull
	@Min(4)
	@Max(6000)
	@Getter @Setter private Integer edad;
	
	@NotNull
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	@Getter @Setter private Date fechaNac;	
	
	/*@NotEmpty
	@Getter @Setter	private String ciudad;*/
	
	//@Valid
	@NotNull
	@Getter @Setter	private Ciudad ciudad;
	
	/*@NotEmpty
	@Getter @Setter private List<String> roles;*/
	
	@NotEmpty
	@Getter @Setter private List<Rol> roles;
	
	@Getter @Setter private Boolean habilitar;
	
	@Getter @Setter private String genero;
	
	@Getter @Setter private String valorSecreto;

}
