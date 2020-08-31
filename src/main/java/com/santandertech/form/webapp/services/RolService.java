package com.santandertech.form.webapp.services;

import java.util.List;

import com.santandertech.form.webapp.models.domain.Rol;

public interface RolService {
	
	public List<Rol> listar();
	public Rol obtenerPorId(Integer id);

}
