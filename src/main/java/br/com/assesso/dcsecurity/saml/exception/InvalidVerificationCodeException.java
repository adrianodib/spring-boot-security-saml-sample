package br.com.assesso.dcsecurity.saml.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.UNAUTHORIZED, reason="Token inválido")
public class InvalidVerificationCodeException extends Exception {
	private static final long serialVersionUID = 100L;
}
