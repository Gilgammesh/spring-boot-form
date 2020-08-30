package com.santandertech.form.webapp.models.domain;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Ciudad {
		
	@Getter @Setter @NotNull private Integer id;	
	@Getter @Setter private String codigo;	
	@Getter @Setter private String nombre;

}
