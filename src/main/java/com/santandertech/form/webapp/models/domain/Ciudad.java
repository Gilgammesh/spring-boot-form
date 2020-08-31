package com.santandertech.form.webapp.models.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Ciudad {
		
	@Getter @Setter private Integer id;	
	@Getter @Setter private String codigo;	
	@Getter @Setter private String nombre;

}
