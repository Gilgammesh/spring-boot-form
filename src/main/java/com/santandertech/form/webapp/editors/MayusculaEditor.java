package com.santandertech.form.webapp.editors;

import java.beans.PropertyEditorSupport;

public class MayusculaEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(text.toUpperCase().trim());
	}
	
	

}
