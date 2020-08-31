package com.santandertech.form.webapp.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.santandertech.form.webapp.services.RolService;

@Component
public class RolesEditor extends PropertyEditorSupport {

	@Autowired
	private RolService rolService;

	@Override
	public void setAsText(String id) throws IllegalArgumentException {
		try {
			Integer id_ = Integer.parseInt(id);
			this.setValue(rolService.obtenerPorId(id_));
		} catch (Exception e) {
			this.setValue(null);
		}
	}

}
