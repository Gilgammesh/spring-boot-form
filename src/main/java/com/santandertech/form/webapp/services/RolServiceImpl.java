package com.santandertech.form.webapp.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.santandertech.form.webapp.models.domain.Rol;

@Service
public class RolServiceImpl implements RolService {
	
	private List<Rol> roles;

	public RolServiceImpl() {
		this.roles = Arrays.asList(
				new Rol(1, "ROLE_ADMIN", "Administrador"), 
				new Rol(2, "ROLE_USER", "Usuario"), 
				new Rol(3, "ROLE_MODERATOR", "Moderador"));
	}

	@Override
	public List<Rol> listar() {
		return roles;
	}

	@Override
	public Rol obtenerPorId(Integer id) {
		Rol result = null;
		for (Rol rol: this.roles) {
			if (id == rol.getId()) {
				result = rol;
				break;
			}
		}
		return result;
	}

}
