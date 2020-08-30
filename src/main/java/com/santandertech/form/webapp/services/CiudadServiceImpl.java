package com.santandertech.form.webapp.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.santandertech.form.webapp.models.domain.Ciudad;

@Component
public class CiudadServiceImpl implements CiudadService {
	
	private List<Ciudad> lista;

	public CiudadServiceImpl() {
		this.lista = Arrays.asList(
				new Ciudad(1, "ta", "Tarapoto"), 
				new Ciudad(2, "mo", "Moyobamba"), 
				new Ciudad(3, "ri", "Rioja"), 
				new Ciudad(4, "la", "Lamas"), 
				new Ciudad(5, "to", "Tocache"), 
				new Ciudad(6, "ju", "Juanjui"), 
				new Ciudad(7, "be", "Bellavista"));
	}

	@Override
	public List<Ciudad> listar() {		
		return lista;
	}

	@Override
	public Ciudad obtenerPorId(Integer id) {
		Ciudad result = null;
		for (Ciudad ciudad: this.lista) {
			if (id == ciudad.getId()) {
				result = ciudad;
				break;
			}
		}
		return result;
	}

}
