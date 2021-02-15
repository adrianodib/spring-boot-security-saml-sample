package br.com.assesso.dcsecurity.saml.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT, reason="Tamanho mínimo de senha não atingido.")
public class PasswordMininumSizeException extends Exception {
	private static final long serialVersionUID = 100L;
}
