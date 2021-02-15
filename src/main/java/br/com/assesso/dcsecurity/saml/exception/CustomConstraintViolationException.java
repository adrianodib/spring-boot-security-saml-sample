package br.com.assesso.dcsecurity.saml.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.UNPROCESSABLE_ENTITY)
public class CustomConstraintViolationException extends Exception 
{
	private static final long serialVersionUID = 100L;
	
	public CustomConstraintViolationException(String message) {
		super(message);
	}
	
}
