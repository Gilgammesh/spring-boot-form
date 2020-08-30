package com.santandertech.form.webapp.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdentificadorRegexpValidador implements ConstraintValidator<IdentificadorRegexp, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value.matches("[A-Z]{3}[-][0-9]{4}")) {
			return true;
		}
		return false;
	}
	
	

}
