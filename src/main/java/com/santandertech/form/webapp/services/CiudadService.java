package com.santandertech.form.webapp.services;

import java.util.List;

import com.santandertech.form.webapp.models.domain.Ciudad;

public interface CiudadService {
	
	public List<Ciudad> listar();
	public Ciudad obtenerPorId(Integer id);

}
