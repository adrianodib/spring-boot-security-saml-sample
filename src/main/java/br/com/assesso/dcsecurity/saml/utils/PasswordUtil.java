package br.com.assesso.dcsecurity.saml.utils;

import org.apache.commons.lang3.StringUtils;

import br.com.assesso.dcsecurity.saml.exception.PasswordMininumSizeException;


public class PasswordUtil {
	
	public static void validatePasswordSize(String passSizeProperty, String formPassword)
			throws PasswordMininumSizeException {
		if (!StringUtils.isBlank(formPassword) && formPassword.length() < passSizeProperty.length()) {
			throw new PasswordMininumSizeException();
		}
	}	
	
	
}
