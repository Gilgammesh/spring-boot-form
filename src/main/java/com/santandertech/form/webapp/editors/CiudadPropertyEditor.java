package com.santandertech.form.webapp.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.santandertech.form.webapp.services.CiudadService;

@Component
public class CiudadPropertyEditor extends PropertyEditorSupport {

	@Autowired
	private CiudadService ciudadService;

	@Override
	public void setAsText(String id) throws IllegalArgumentException {
		try {
			Integer id_ = Integer.parseInt(id);
			this.setValue(ciudadService.obtenerPorId(id_));
		} catch (Exception e) {
			this.setValue(null);
		}
	}

}
