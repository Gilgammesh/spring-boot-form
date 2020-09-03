package com.santandertech.form.webapp.models.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor public class Rol {
	
	@Getter @Setter private Integer id;
	@Getter @Setter private String rol;
	@Getter @Setter private String nombre;
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		
		if(!(obj instanceof Rol)) {
			return false;
		}
		
		Rol rol = (Rol) obj;
		return this.id != null && this.id.equals(rol.getId());
	}	
	
}
